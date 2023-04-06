package Maswillaeng.MSLback.utils.auth;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

@Component
public class AESEncryption {

    private static final String encryptionAlgo = "AES/CBC/PKCS5Padding";
    @Value("${secret.access}")
    private String SECRET_KEY;

    public String encrypt(String password) {

        byte[] encrypted = {};
        try {
            Cipher cipher = Cipher.getInstance(encryptionAlgo);
            SecretKeySpec keySpec = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");
            IvParameterSpec ivParamSpec = new IvParameterSpec(SECRET_KEY.substring(0, 16).getBytes());
            cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivParamSpec);
            encrypted = cipher.doFinal(password.getBytes("UTF-8"));
        } catch (Exception e) {
            throw new RuntimeException();
        }

        return Base64.getEncoder().encodeToString(encrypted);
    }
}
