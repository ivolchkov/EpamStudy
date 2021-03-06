package ua.epam.task5.student.service.encode;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Component
public class PasswordEncoder {
    private static final Logger LOGGER = Logger.getLogger("file");

    public String encode(String pass){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] passBytes = pass.getBytes();
            md.reset();
            byte[] digested = md.digest(passBytes);
            StringBuffer sb = new StringBuffer();

            for (byte b : digested) {
                sb.append(Integer.toHexString(0xff & b));
            }

            return sb.toString();
        } catch (NoSuchAlgorithmException ex) {
            LOGGER.error("Encode process exception", ex);
            throw new RuntimeException(ex);
        }
    }
}
