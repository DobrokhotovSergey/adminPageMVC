package ua.laksmi.web.domain.roles;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.*;

/**
 * Created by Dobriks on 11.03.2017.
 */
public class EncryptionServise {
    Cipher cipher;
    byte[] keyBytes = "A7lexand4rLa3k2smiG9roup".getBytes();
    SecretKeySpec key = new SecretKeySpec(keyBytes, "AES");
    {
      Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
      try {
            cipher = Cipher.getInstance("AES/ECB/PKCS7Padding", "BC");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public byte[] encrypt(String inputString) throws InvalidKeyException, ShortBufferException, BadPaddingException, IllegalBlockSizeException {
        byte[] input = inputString.getBytes();
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] cipherText = new byte[cipher.getOutputSize(input.length)];
        int ctLength = cipher.update(input, 0, input.length, cipherText, 0);
        ctLength += cipher.doFinal(cipherText, ctLength);
        return cipherText;
    }
    public String decrypt(byte[] cipherText) throws InvalidKeyException, ShortBufferException, BadPaddingException, IllegalBlockSizeException {
        int ctLength = cipherText.length;
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] plainText = new byte[cipher.getOutputSize(ctLength)];
        int ptLength = cipher.update(cipherText, 0, ctLength, plainText, 0);
        ptLength += cipher.doFinal(plainText, ptLength);
        return new String(plainText).trim();
    }

}
