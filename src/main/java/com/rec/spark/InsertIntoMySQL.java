package com.rec.spark;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.sql.*;
import org.apache.spark.sql.types.*;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;


public class InsertIntoMySQL implements MySqlConnect,Serializable {

    public static void insert(List<String>array, JavaSparkContext sc){

        SQLContext sqlContext = new SQLContext(sc);

        JavaRDD<String[]> movieRDD = sc.parallelize(array).map(
                new Function<String, String[]>() {
                    @Override
                    public String[] call(String s) throws Exception {
                        return s.split("::");
                    }
                }
        );

        JavaRDD<Row> rowRDD = movieRDD.map(
                new Function<String[], Row>() {
                    @Override
                    public Row call(String[] rows) throws Exception {
                        return RowFactory.create(
                                Integer.parseInt(rows[0]),
                                Integer.parseInt(rows[1]),
                                Float.parseFloat(rows[2]),
                                rows[3]
                        );
                    }
                }
        );
        List<StructField> list = new ArrayList<>();
        list.add(DataTypes.createStructField("userid", DataTypes.IntegerType, true));
        list.add(DataTypes.createStructField("movieid", DataTypes.IntegerType, true));
        list.add(DataTypes.createStructField("rating", DataTypes.FloatType, true));
        list.add(DataTypes.createStructField("moviename", DataTypes.StringType, true));
        StructType schema = DataTypes.createStructType(list);

        Dataset<Row> movieDF = sqlContext.createDataFrame(rowRDD, schema);
        Properties prop = new Properties();
        prop.put("user", MySqlConnect.user);
        prop.put("password", MySqlConnect.password);
        prop.put("driver",MySqlConnect.driver);

        movieDF.write().mode("append").jdbc(MySqlConnect.url,"movierecommend.recommendresult",prop);
    }
}

