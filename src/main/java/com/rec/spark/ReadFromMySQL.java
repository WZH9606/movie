package com.rec.spark;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SQLContext;
import scala.Function1;
import scala.collection.mutable.ArrayBuffer;

import java.io.Serializable;
import java.sql.*;
import java.util.List;

/**
 *
 */
public class ReadFromMySQL implements MySqlConnect ,Serializable {

    public static JavaRDD<String> read(int userId,JavaSparkContext sc) {
        SQLContext sqlContext = new SQLContext(sc);

        Dataset<Row> personalRatingsDF = sqlContext.read().format("jdbc").
                option("url", MySqlConnect.url).
                option("driver", MySqlConnect.driver).
                option("dbtable", "personalratings").
                option("user", MySqlConnect.user).
                option("password", MySqlConnect.password).load();
        personalRatingsDF.show();
        personalRatingsDF.createOrReplaceTempView("personalratings");
        Dataset<Row> prDF = sqlContext.sql("select * from personalratings where userid=" + userId);

        JavaRDD<String> myrdd = prDF.javaRDD().map(new Function<Row, String>() {
            @Override
            public String call(Row r) throws Exception {
                return r.get(0).toString() + "::" + r.get(1).toString() + "::" + r.get(2).toString() + "::" + r.get(3).toString();
            }
        });

        return myrdd;
    }
}
