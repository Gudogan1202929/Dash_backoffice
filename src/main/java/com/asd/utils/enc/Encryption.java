package com.asd.utils.enc;

import com.asd.utils.constant.SystemConstants;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.util.Base64;

public class Encryption {

    public static String Encrypt(String password) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(SystemConstants.THE_KEY_FOR_ENC.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance(SystemConstants.TYPE_ENC);
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
        byte[] encryptedBytes = cipher.doFinal(password.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public static String Decrypt(String password) throws Exception{
        SecretKeySpec secretKeySpec = new SecretKeySpec(SystemConstants.THE_KEY_FOR_ENC.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance(SystemConstants.TYPE_ENC);
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
        byte[] encryptedBytes = Base64.getDecoder().decode(password);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        return new String(decryptedBytes, StandardCharsets.UTF_8);
    }
}
