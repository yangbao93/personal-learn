package com.personal.codelearn.java.spark;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.functions;

/**
 * @author ：yangbao
 * @description：
 * @version: $
 * @date ：Created in 2020/7/21 8:30 下午
 * @modified By：
 */
public class ReadHive {

    public static void main(String[] args) {
        SparkSession spark = SparkSession.builder()
                .appName("SparkHiveDemo")
                .master("local[2]")
//                .config("spark.sql.warehouse.dir", "/fortest")
                .enableHiveSupport()
                .getOrCreate();
        String filePath1 = "/Users/yangbao/projects/personal-learn/code-learn/src/main/resources/templates/hive.txt";
        Dataset<Row> dataset1 = spark.read().text(filePath1)
                .selectExpr("CAST(value AS STRING) AS string_value")
                .select(functions.split(functions.col("string_value"), "\t").as("split_value"));
        dataset1.show(1);
    }

}
