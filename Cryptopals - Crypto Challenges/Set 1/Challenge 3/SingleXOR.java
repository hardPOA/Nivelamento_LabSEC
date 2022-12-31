

public class SingleXOR {


    public static void main(String[] args) { 

        String cipher = "1b37373331363f78151b7f2b783431333d78397828372d363c78373e783a393b3736";
        byte cipher2Hex[] = new byte[cipher.length()/2];
        String highestValueString = "";
        int highestValue = 0;
        char key = 'a';
    
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
                    key = c;
                }
            }
        }
        System.out.println(String.format("Mensagem encriptada com a chave '%c': %s", key, highestValueString));

    }
}

