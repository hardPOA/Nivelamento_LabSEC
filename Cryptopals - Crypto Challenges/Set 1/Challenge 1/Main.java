import java.util.*;

class Main {
  public static void main(String[] args) {
    

    String stringHex = "49276d206b696c6c696e6720796f757220627261696e206c696b65206120706f69736f6e6f7573206d757368726f6f6d";

    byte bytes[] = new byte[stringHex.length()/2];

    for (int i = 0; i < stringHex.length(); i += 2) {
      byte b = Integer.valueOf(stringHex.substring(i,i+2), 16).byteValue();
      bytes[i/2] = b;
    }

    System.out.println(Arrays.toString(bytes));
    System.out.println();
    String convertido = Base64.conversorBase64(bytes);
    System.out.println(convertido);
    
  }
}