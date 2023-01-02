

public class SingleXOR {

    public static CustomObject singleXOR(String line) { 

        String cipher = line;
        byte cipher2Hex[] = new byte[cipher.length()/2];
        String highestValueString = "";
        int highestValue = 0;
    
        for (int i = 0; i < cipher.length(); i += 2) {
    
            byte b = Integer.valueOf(cipher.substring(i, i+2), 16).byteValue();
            cipher2Hex[i/2] = b;

        }

        //System.out.println(Arrays.toString(cipher2Hex));

        for (int i = -128; i < 127; i++) {
            String decoded = "";
            int stringValue = 0;
            
            for (byte b : cipher2Hex) {
                char c = (char) (b ^ i);
                decoded += c;

                if (c == 'e') {
                    stringValue += 5;

                } else if (c == 't') {
                    stringValue += 4;

                } else if (c == 'a' | c == 'i' | c == 'n' | c == 'o' | b == 'c') {
                    stringValue += 3;

                }

                if (stringValue > highestValue) {
                    highestValue = stringValue;
                    highestValueString = decoded;
                }
            }
        }
        //System.out.println(highestValueString);
        return new CustomObject(highestValueString, highestValue);
    }
}
    
