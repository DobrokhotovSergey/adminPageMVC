package ua.laksmi.config.core;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by Dobriks on 20.04.2017.
 */
public class PasswordEncoderGenerator {

    public static void main(String[] args) {

        int i = 0;

            String password = "123admin";
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String hashedPassword = passwordEncoder.encode(password);

            System.out.println(hashedPassword);



    }
}
