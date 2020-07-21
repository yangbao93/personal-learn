package com.personal.codelearn.java.spark.gateway;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.functions;
import org.apache.spark.sql.types.StructType;

/**
 * 从日志平台提取网关日志，用于统计用户活跃度等指标，相比第一版增加端区分标识，端版本号等
 */
public class UserActivityV3 {

    private static final String GATEWAY_APM_SRC_ID_LIST = "3150";

    public static void main(String[] args) {
//        if (args.length < 2) {
//            System.err.println(
//                    "Usage: spark-submit UserActivityV2 <inputPath> <outputPath> [<logSrcIdList>]");
//            System.exit(1);
//        }
//        SparkSession spark = SparkSession
//                .builder()
//                .appName("UserActivityV3")
//                .getOrCreate();
        SparkSession spark = SparkSession.builder().appName("UserActivityV3").
                enableHiveSupport().master("local[2]").getOrCreate();
//        String inputPath = args[0];
//        String outputPath = args[1];
        String inputPath = "/Users/yangbao/projects/personal/personalScalaDemo/src/main/java/gateway/in/*";
        String outputPath = "/Users/yangbao/projects/personal/personalScalaDemo/src/main/java/gateway/out";

        String outputMode = "overwrite";

        StructType jsonSchema = new StructType()
                .add("message", "string")
//                .add("logSrcId", "bigint")
                .add("time", "string");
        Dataset<Row> dfRequestCount1 = spark.read()
                .text(inputPath)
                .selectExpr("CAST(value AS STRING) AS value_json_string")
                .select(functions.from_json(functions.col("value_json_string"),
                        jsonSchema).as("value_json"))
                // .filter("value_json.logSrcId IN (" + logSrcIdList + ")")
//                .filter("value_json.message like 'requestId:%gateway-UserLoginInfoDTO%'")
                .select(
//                        functions.date_format(functions.from_unixtime(functions.floor(
//                                functions.col("value_json.time").divide(1000))), "yyyy-MM-dd").as("opDate"),
                        functions.date_format(functions.col("value_json.time"), "yyyy-MM-dd").as("opDate"),

                        functions.regexp_extract(
                                functions.col("value_json.message"),
                                "gateway-UserLoginInfoDTO\\((.+)\\)", 1).as("userLoginInfo")
                )
                .groupBy("opDate", "userLoginInfo")
                .count();
        // 处理\t之类的太乱了
        Dataset<Row> dfRequestCount2 = dfRequestCount1
                .select(
                        functions.concat_ws("\t", functions.col("opDate"),
                                functions.regexp_replace(
                                        functions.regexp_replace(functions.col("userLoginInfo"), "(\\w+?)=", ""),
                                        ", ", "\t"),
                                functions.col("count")).as("value"));
        dfRequestCount2.explain(true);

        dfRequestCount2.coalesce(1).write()
                .format("text")
                .mode(outputMode)
                .option("path", outputPath)
                .save();
        spark.stop();
    }
}
