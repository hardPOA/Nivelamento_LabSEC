import java.io.*;

public class RepeatingkeyXOR {

    public static void main(String[] args) throws Exception {

        String hexTable = "0123456789ABCDEF";
        File file = new File("stanza.txt");
        BufferedReader fileLine = new BufferedReader(new FileReader(file));
        String source;
        String destination = "";

        while ((source = fileLine.readLine()) != null) {

            for (int i = 0; i < source.length(); i++) {

                char c = source.charAt(i);
                byte b = Integer.valueOf(c).byteValue();
    
    
                switch (i % 3) {
                
                case 0:
                    //destination += (char) ((b ^ 0x49) & 0xFF);
                    destination += hexTable.charAt((((b ^ 0x49) >> 4) & 0x0F));
                    destination += hexTable.charAt(((b ^ 0x49) & 0x0F));
                    //System.out.println("char: " + c + " // destination: " + destination);
                    break;
    
                case 1:
                    //destination += (char) ((b ^ 0x43) & 0xFF);
                    destination += hexTable.charAt((((b ^ 0x43) >> 4) & 0x0F));
                    destination += hexTable.charAt(((b ^ 0x43) & 0x0F));
                    //System.out.println("char: " + c + "destination: " + destination);
                    break;
    
                case 2:
                    //destination += (char) ((b ^ 0x45) & 0xFF);
                    destination += hexTable.charAt((((b ^ 0x45) >> 4) & 0x0F));
                    destination += hexTable.charAt(((b ^ 0x45) & 0x0F));
                    //System.out.println("char: " + c + "destination: " + destination);
                    break;
                }
    
            }


        }
        
        //System.out.println("ascii: " + destination);
        System.out.println("HEX ENCODED: " + destination);






    

    }
}