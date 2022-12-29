public class Base64 {


  
    private static String tabelaDeCaracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";


  
    private static char base64Char(int i) {
      return tabelaDeCaracteres.charAt(i);
  }


    public static String conversorBase64(byte[] b) {
      String b64 = "";
      int index = 0;

      for (; index < b.length - 2; index += 3) {
        int trecho = (b[index] << 16) | (b[index + 1] << 8) | b[index + 2];
        b64 += base64Char((trecho >> 18) & 0x3F);
        b64 += base64Char((trecho >> 12) & 0x3F);
        b64 += base64Char((trecho >> 6) & 0x3F);
        b64 += base64Char(trecho & 0x3F);
      }

      int sobra = b.length % 3;

      switch (sobra) {
        case 2:
          int trechoA = (b[index++] << 16) | (b[index++] << 8);
          b64 += base64Char((trechoA >> 18) & 0x3F);
          b64 += base64Char((trechoA >> 12) & 0x3F);
          b64 += base64Char((trechoA >> 6) & 0x3F);
          b64 += "=";
          
        case 1:
          int trechoB = (b[index++] << 16);
          b64 += base64Char((trechoB >> 18) & 0x3F);
          b64 += base64Char((trechoB >> 12) & 0x3F);
          b64 += "==";
          break;
      }
        
      return b64;
  }
  
}