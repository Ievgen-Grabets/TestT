package evg.testt.service.impl;

import evg.testt.service.EncryptionService;
import org.springframework.stereotype.Service;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

@Service
public class EncryptionServiceImpl implements evg.testt.service.EncryptionService {

    private final String KEY = "Bar12345Bar12345"; // 128 bit key

    @Override
    public String encryptString(String source) throws InvalidKeyException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, NoSuchAlgorithmException {


            // Create key and cipher
            Key aesKey = new SecretKeySpec(KEY.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            // encrypt the source
            cipher.init(Cipher.ENCRYPT_MODE, aesKey);
            byte[] encrypted = cipher.doFinal(source.getBytes());
            return new String(encrypted);

            // decrypt the source
            //cipher.init(Cipher.DECRYPT_MODE, aesKey);
            //String decrypted = new String(cipher.doFinal(encrypted));

    }
}
