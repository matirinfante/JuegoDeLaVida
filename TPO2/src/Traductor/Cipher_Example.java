/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Traductor;

/**
 *
 * @author Matt
 */
import java.security.Security;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Cipher_Example {

    public static void main(String[] args) throws Exception {

        //Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
        byte[] password = "JavaJavaJavaJava".getBytes("UTF-8");

        byte[] pkey = "keykeykekeykeykekeykeykekeykeyke".getBytes("UTF-8");

        SecretKeySpec secretKey = new SecretKeySpec(pkey, "AES");

        Cipher c = Cipher.getInstance("AES/ECB/NoPadding");

        System.out.println("User password(plaintext) : " + new String(password));

        // encrypt password
        byte[] cText = new byte[password.length];

        c.init(Cipher.ENCRYPT_MODE, secretKey);

        int ctLen = c.update(password, 0, password.length, cText, 0);

        ctLen += c.doFinal(cText, ctLen);

        System.out.println("Password encrypted: " + cText.toString().getBytes("UTF-8").toString() + " bytes: " + ctLen);

        // decrypt password
        byte[] plainText = new byte[ctLen];

        c.init(Cipher.DECRYPT_MODE, secretKey);

        int plen = c.update(cText, 0, ctLen, plainText, 0);

        plen += c.doFinal(plainText, plen);

        System.out.println("User password(plaintext) : " + new String(plainText) + " bytes: " + plen);
    }
}
