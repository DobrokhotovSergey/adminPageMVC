package ua.laksmi.web.domain.test;

import ua.laksmi.web.domain.roles.EncryptionServise;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.ShortBufferException;
import java.security.InvalidKeyException;

/**
 * Created by Dobriks on 11.03.2017.
 */
public class Test {
    public static void main(String[] args) throws IllegalBlockSizeException, BadPaddingException, ShortBufferException, InvalidKeyException {
        EncryptionServise en = new EncryptionServise();
        //System.out.println(en.encrypt("testPassw").length);
        byte[] byteArr = en.encrypt("testPassw");

        System.out.println( en.decrypt(byteArr));
       // System.out.println(en.encrypt("testPassw").toString().getBytes());
    }
}
