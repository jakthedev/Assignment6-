
import java.io.BufferedReader;

public class AnalyzingSalesData {

    public static void main(String[] args) {

        BufferedReader salesReader = null;

        try {
            salesReader = new BufferedReader(new FileReader("model3.csv"));
            //salesReader.readline();
            while (salesReader.readline() != null) {
                String model3Info = salesReader.readline();
                String[] allModel3Info = model3Info.split(",");
            }

        }
    } finally

    {

    }
}