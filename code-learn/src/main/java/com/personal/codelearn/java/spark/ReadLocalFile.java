import org.apache.spark.api.java.function.MapFunction;
import org.apache.spark.sql.AnalysisException;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoder;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class ReadLocalFile {

    public static void main(String[] args) throws AnalysisException {
        SparkSession sparkSession = SparkSession.builder().appName("readLocalData").
                enableHiveSupport().master("local[2]").getOrCreate();
//        String localFilePath = "/Users/yangbao/projects/personal/personalScalaDemo/src/main/resources/JavaLocalData";
        String localFilePath = "/Users/yangbao/projects/personal/personalScalaDemo/src/main/resources/localData.csv";

        Dataset<Row> dataset = sparkSession.read().text(localFilePath);
        Encoder<Local> encoder = Encoders.bean(Local.class);

        Dataset<Local> rowDataset = dataset.map(new MapFunction<Row, Local>() {
            @Override
            public Local call(Row v1) throws Exception {
                String s = v1.getString(0);
                System.out.println(s);
                String[] split = s.split("\\t");
                Local local = new Local();
                local.setV1(split[0]);
                local.setV2(split[1]);
                local.setV3(split[2]);
                return local;
            }

        }, encoder);
        rowDataset.show();
        rowDataset.createTempView("temp_table");
        Dataset<Row> dataset2 = sparkSession.sql("select * from temp_table where v1 = 20200102");
        dataset2.show();
    }

}
