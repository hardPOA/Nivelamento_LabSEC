
import java.io.*;

public class detectSingleCharXOR {

    public static void main(String[] args) throws Exception {
        File file = new File("C:\\Users\\Vinicius\\Desktop\\Java 3\\source.txt");
        BufferedReader fileLine = new BufferedReader(new FileReader(file));
        String line;
        int hv = 0;
        String hvs = "";

        while ((line = fileLine.readLine()) != null) {
            //System.out.println("linha " + line);
            CustomObject retObj = SingleXOR.singleXOR(line);

            if (retObj.highestValue > hv) {
                hv = retObj.highestValue;
                hvs = retObj.highValueString;
            }

        }

        System.out.println("hv: " + hv + "\nhvs: " + hvs);

    }
    
}
