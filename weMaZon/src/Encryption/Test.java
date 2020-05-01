package Encryption;

/**
 * Created by oakinrele on Jan, 2020
 */
public class Test {
    public static void main(String[] args)
    {
        final String secretKey = "ACCESSAMS";

        String originalString = "success4000%";
        char [] toCharArray = originalString.toCharArray();

        EncryptionClass encryptionClass = new EncryptionClass();

        //String encryptedString = EncryptionClass.encrypt(originalString, secretKey);

        System.out.println(new String(toCharArray));
        String encryptedString2 = AES.encrypt(new String(toCharArray), secretKey);
        System.out.println(encryptedString2);
        String decryptedString = AES.decrypt(new String(toCharArray), secretKey);
        System.out.println(decryptedString);
        System.out.println("New String");
        System.out.println(originalString);
        String encryptedString = AES.encrypt(originalString, secretKey);
        System.out.println(encryptedString);
        String decryptedString2 = AES.decrypt(originalString, secretKey);
        System.out.println(decryptedString2);
    }
}
