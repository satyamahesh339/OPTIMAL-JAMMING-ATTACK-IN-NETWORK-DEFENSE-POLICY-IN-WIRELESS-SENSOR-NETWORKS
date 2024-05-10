package sensor_priority.Com.multi.nw;

import java.security.InvalidKeyException;
import java.security.Key;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;

public class EncryptDecrypt {
	private static String algorithm = "DESede";
    private static Key key = null;
    private static Cipher cipher = null;
    //private String input=null;
    
    
    public String EncryptDecrypt1(String message)throws Exception 
    {
        setUp();
        byte[] encryptionBytes = null;
        String input = message;
        encryptionBytes = encrypt(input);
        String str=encryptionBytes.toString();
        // System.out.println(encryptionBytes);
        //System.out.println("Recovered: " + decrypt(encryptionBytes));
        String str2=str+"|"+decrypt(encryptionBytes);
        return str2;
    }

    private static byte[] encrypt(String input)throws InvalidKeyException,BadPaddingException,IllegalBlockSizeException {
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] inputBytes = input.getBytes();
        return cipher.doFinal(inputBytes);
    }

    private static String decrypt(byte[] encryptionBytes)throws InvalidKeyException,BadPaddingException,IllegalBlockSizeException {
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] recoveredBytes = 
          cipher.doFinal(encryptionBytes);
        String recovered = 
          new String(recoveredBytes);
        return recovered;
      }
    private static void setUp() throws Exception {
        key = KeyGenerator.getInstance(algorithm).generateKey();
        cipher = Cipher.getInstance(algorithm);
        
    }
    


}
