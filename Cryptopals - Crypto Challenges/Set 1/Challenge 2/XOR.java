import java.util.*;

class XOR {

    public static void main(String[] args) {
        
        String buffer1 = "1c0111001f010100061a024b53535009181c";
        String buffer2 = "686974207468652062756c6c277320657965";
        StringBuilder encoded = new StringBuilder();

        if (buffer1.length() != buffer2.length()) {
            System.out.println("utilize strings de mesmo tamanho");
        } else {
            {
                for (int i = 0; i < buffer1.length(); i += 2) {
                    byte b1 = Integer.valueOf(buffer1.substring(i,i+2), 16).byteValue();
                    byte b2 = Integer.valueOf(buffer2.substring(i,i+2), 16).byteValue();
                    //System.out.println(String.format("b1: %s; b2: %s", b1, b2));
                    int result = (b1 ^ b2);
                    encoded.append(String.format("%02X", result));
                }
            }
        System.out.println(encoded);
        }
    }
}
