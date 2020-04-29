/*

package com.rec.spark;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.broadcast.Broadcast;
import org.apache.spark.mllib.recommendation.ALS;
import org.apache.spark.mllib.recommendation.MatrixFactorizationModel;
import org.apache.spark.mllib.recommendation.Rating;
import scala.Tuple2;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.*;



public class MovieLensALS implements Serializable {

    public JavaRDD<Rating> loadRatings(JavaRDD<String> lines) {
        JavaRDD<Rating> ratings = lines.map(new Function<String, Rating>() {
            @Override
            public Rating call(String s) throws Exception {
                String[] fields = s.split("::");
                return new Rating(
                        Integer.parseInt(fields[0]),
                        Integer.parseInt(fields[1]),
                        Double.parseDouble(fields[2])
                );
            }
        }).filter(new Function<Rating, Boolean>() {
            @Override
            public Boolean call(Rating rating) throws Exception {
                return rating.rating() > 0.0;
            }
        });
        return ratings;

    }

    public Double computeRmse(MatrixFactorizationModel model, JavaRDD<Rating> data, Long n) {
        JavaPairRDD<Integer, Integer> pairRDD = data.mapToPair(new PairFunction<Rating, Integer, Integer>() {
            @Override
            public Tuple2<Integer, Integer> call(Rating rating) throws Exception {
                return new Tuple2<>(rating.user(), rating.product());
            }
        });

        JavaRDD<Rating> predictions = model.predict(pairRDD);
        JavaRDD<Integer> mapuser = data.map(new Function<Rating, Integer>() {
            @Override
            public Integer call(Rating rating) throws Exception {
                return rating.user();
            }
        });
        JavaRDD<Integer> mapproduct = data.map(new Function<Rating, Integer>() {
            @Override
            public Integer call(Rating rating) throws Exception {
                return rating.product();
            }
        });
        JavaRDD<Double> maprating = data.map(new Function<Rating, Double>() {
            @Override
            public Double call(Rating rating) throws Exception {
                return rating.rating();
            }
        });

        // 输出predictionsAndRatings预测和评分
        JavaRDD<Tuple2<Double, Double>> predictionsAndRatings = predictions.mapToPair(new PairFunction<Rating, Tuple2<Integer, Integer>, Double>() {
            @Override
            public Tuple2<Tuple2<Integer, Integer>, Double> call(Rating rating) throws Exception {
                return new Tuple2<>(new Tuple2<>(rating.user(), rating.product()), rating.rating());
            }
        }).join(data.mapToPair(new PairFunction<Rating, Tuple2<Integer, Integer>, Double>() {
            @Override
            public Tuple2<Tuple2<Integer, Integer>, Double> call(Rating rating) throws Exception {
                return new Tuple2<>(new Tuple2<>(rating.user(), rating.product()), rating.rating());
            }
        })).values();

        return Math.sqrt(predictionsAndRatings.map(new Function<Tuple2<Double, Double>, Double>() {
            @Override
            public Double call(Tuple2<Double, Double> x) throws Exception {
                return (x._1 - x._2) * (x._1 - x._2);
            }
        }).reduce(new Function2<Double, Double, Double>() {
            @Override
            public Double call(Double a, Double b) throws Exception {
                return a + b;
            }
        }) / n);
    }

    public double mean(List<Double> arr) {
        Double sum = 0.0;
        for (int i = 0; i < arr.size(); i++) {
            sum += arr.get(i);
        }
        return sum / arr.size();

    }


    public void movieLensALS(String movieLensHomeDir, int userId) throws SQLException {
        // 设置运行环境
        SparkConf conf = new SparkConf().setAppName("MovieLensALS").setMaster("local[1]");
        JavaSparkContext sc = new JavaSparkContext(conf);

        Broadcast<Integer> bcUserid = sc.broadcast(userId);

        // 删除该用户之前已经存在的电影推荐结果，为本次写入最新的推荐结果做准备
        DeleteFromMySQL.delete(bcUserid.getValue());

        // 从关系型数据库中读取该用户对一些电影的个性化评分数据
        JavaRDD<String> personalRatingsLines = ReadFromMySQL.read(bcUserid.getValue(),sc);

        JavaRDD<Rating> myRatings = loadRatings(personalRatingsLines);
        JavaRDD<Rating> myRatingsRDD = sc.parallelize(myRatings.collect(),1);

        // 装载样本评分数据，其中最后一列Timestamp取除10的余数作为key，Rating为值,即(Int,Rating)
        // ratings.dat原始数据：用户编号、电影编号、评分、评分时间戳
        JavaPairRDD<Long, Rating> ratings = sc.textFile(movieLensHomeDir + "ratings.dat", 1)
                .mapToPair(new PairFunction<String, Long, Rating>() {
                    @Override
                    public Tuple2<Long, Rating> call(String s) throws Exception {
                        String[] fields = s.split("::");
                        return new Tuple2<>(Long.parseLong(fields[3])%10, new Rating(
                                Integer.parseInt(fields[0]),
                                Integer.parseInt(fields[1]),
                                Double.parseDouble(fields[2])
                        ));
                    }
                });

        // 装载电影目录对照表 （电影 ID -> 电影标题）
        //movies.dat原始数据：电影编号、电影名称、电影类别
//        JavaPairRDD<Integer, String> movies = sc.textFile(movieLensHomeDir + "movies.dat", 1)
//                .mapToPair(new PairFunction<String, Integer, String>() {
//                    @Override
//                    public Tuple2<Integer, String> call(String s) throws Exception {
//                        String[] fields = s.split("::");
//                        return new Tuple2<>(Integer.parseInt(fields[0]), fields[1]);
//                    }
//                });
        JavaPairRDD<Integer, String> movies = sc.textFile(movieLensHomeDir + "movies.dat", 1)
                .mapToPair(new PairFunction<String, Integer, String>() {
                    @Override
                    public Tuple2<Integer, String> call(String s) throws Exception {
                        String[] fields = s.split("::");
                        return new Tuple2<>(Integer.parseInt(fields[0]), fields[1]);
                    }
                });

        long numRatings = ratings.count();

        long numUsers = ratings.map(new Function<Tuple2<Long, Rating>, Integer>() {
            @Override
            public Integer call(Tuple2<Long, Rating> t) throws Exception {
                return t._2.user();
            }
        }).distinct().count();

        long numMovies = ratings.map(new Function<Tuple2<Long, Rating>, Integer>() {
            @Override
            public Integer call(Tuple2<Long, Rating> t) throws Exception {
                return t._2.product();
            }
        }).distinct().count();

        // 将样本评分表以key值切分成3个部分，分别用于训练 (60%，并加入用户评分), 校验 (20%), and 测试 (20%)
        // 该数据在计算过程中要多次应用到，所以cache到内存
        Integer numPartitions = 4;

        // training训练样本数据
        JavaRDD<Rating> training = ratings.filter(new Function<Tuple2<Long, Rating>, Boolean>() {
            @Override
            public Boolean call(Tuple2<Long, Rating> t) throws Exception {
                return t._1 < 6; //取评分时间除10的余数后值小于6的作为训练样本
            }
        }).values().union(myRatingsRDD).repartition(numPartitions).cache();

        // validation校验样本数据
        JavaRDD<Rating> validation = ratings.filter(new Function<Tuple2<Long, Rating>, Boolean>() {
            @Override
            public Boolean call(Tuple2<Long, Rating> t) throws Exception {
                return t._1 >= 6 && t._1 < 8;
            }
        }).values().repartition(numPartitions).cache();


        // test测试样本数据
        JavaRDD<Rating> test = ratings.filter(new Function<Tuple2<Long, Rating>, Boolean>() {
            @Override
            public Boolean call(Tuple2<Long, Rating> t) throws Exception {
                return t._1 >= 8;
            }
        }).values().cache();

        long numTraining = training.count();
        long numValidation = validation.count();
        long numTest = test.count();

        // 训练不同参数下的模型，并在校验集中验证，获取最佳参数下的模型
        int[] ranks = new int[]{8, 12}; //模型中隐语义因子的个数
        double[] lambdas = new double[]{0.1, 10.0}; //是ALS的正则化参数
        int[] numIters = new int[]{10, 20}; //迭代次数


        //var bestModel: Option[MatrixFactorizationModel] = None //最好的模型

        MatrixFactorizationModel bestModel = null;
        double bestValidationRmse = Double.MAX_VALUE;
        int bestRank = 0;  //最好的隐语义因子的个数
        double bestLambda = 0.0; //最好的ALS正则化参数
        int bestNumIter = 0; //最好的迭代次数

        for (int i = 0; i < ranks.length; i++) {
            int rank = ranks[i];
            for (int j = 0; j < lambdas.length; j++) {
                double lambda = lambdas[j];
                for (int k = 0; k < numIters.length; k++) {
                    int numIter = numIters[k];

                    //训练样本、隐语义因子的个数、迭代次数、ALS的正则化参数
                    MatrixFactorizationModel model = ALS.train(training.rdd(), rank, numIter, lambda);
                    // 校验模型结果
                    Double validationRmse = computeRmse(model, validation, numValidation);
                    if (validationRmse < bestValidationRmse) {
                        bestModel = model;
                        bestValidationRmse = validationRmse;
                        bestRank = rank;
                        bestLambda = lambda;
                        bestNumIter = numIter;
                    }

                }
            }
        }
        // 用最佳模型预测测试集的评分，并计算和实际评分之间的均方根误差
        Double testRmse = computeRmse(bestModel, test, numTest);

        //创建一个naive基线和最好的模型比较
        Double meanRating = mean(training.union(validation).map(new Function<Rating, Double>() {
            @Override
            public Double call(Rating rating) throws Exception {
                return rating.rating();
            }
        }).collect());
        Broadcast<Double> bcMeanRating = sc.broadcast(meanRating);

        double baselineRmse = Math.sqrt(mean(test.map(new Function<Rating, Double>() {
            @Override
            public Double call(Rating rating) throws Exception {
                return (bcMeanRating.getValue() - rating.rating()) * (bcMeanRating.getValue() - rating.rating());
            }
        }).collect()));
        //提高了基线的最佳模型
        double improvement = (baselineRmse - testRmse) / baselineRmse * 100;

        // 推荐前5部最感兴趣的电影，注意要剔除用户已经评分的电影
        JavaRDD<Integer> myRatedMovieIds = myRatings.map(new Function<Rating, Integer>() {
            @Override
            public Integer call(Rating rating) throws Exception {
                return rating.product();
            }
        });

        Set<Integer> myRatedMoviesIdsSet = new HashSet<>(myRatedMovieIds.collect());
        Broadcast<Set<Integer>> bcMyRatedMoviesIdsSet = sc.broadcast(myRatedMoviesIdsSet);


        JavaRDD<Integer> candidates = movies.filter(new Function<Tuple2<Integer, String>, Boolean>() {
            @Override
            public Boolean call(Tuple2<Integer, String> t) throws Exception {
                return !bcMyRatedMoviesIdsSet.getValue().contains(t._1);
            }
        }).keys();

        List<Rating> takeRDD = bestModel.predict(candidates.mapToPair(new PairFunction<Integer, Integer, Integer>() {
            @Override
            public Tuple2<Integer, Integer> call(Integer i) throws Exception {
                return new Tuple2<>(bcUserid.getValue(), i);
            }
        })).sortBy(new Function<Rating, Double>() {
            @Override
            public Double call(Rating rating) throws Exception {
                return rating.rating();
            }
        }, true, 1).take(10);
        List<String> rddForMySQL = new ArrayList<>();
        for (int i = 0; i < takeRDD.size(); i++) {
            Rating r = takeRDD.get(i);
            rddForMySQL.add(r.user() + "::" + r.product() + "::" + r.rating() + "::" + movies.lookup(r.product()));
        }
        //把推荐结果写入数据库
        InsertIntoMySQL.insert(rddForMySQL,sc);

        int i = 1;
        System.out.println("Movies recommended for you(用户ID：推荐电影ID：推荐分数：推荐电影名称):");
        for (int j = 0; j < rddForMySQL.size(); j++) {
            System.out.println(rddForMySQL.get(j));
            i+=1;
        }

        sc.stop();


    }

    public static void main(String[] args) throws SQLException {

        Logger.getLogger("org.apache.spark").setLevel(Level.ERROR);
        Logger.getLogger("org.eclipse.jetty.server").setLevel(Level.OFF);
        String movieLensHomeDir = "./Files/";
        int userid = 1;
        MovieLensALS movieLensALS = new MovieLensALS();

        movieLensALS.movieLensALS(movieLensHomeDir, userid);
    }


}

*/
