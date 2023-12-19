package com.gustavoTBett.cryptography.service;

import com.gustavoTBett.cryptography.dto.CryptographyDtoInsert;
import com.gustavoTBett.cryptography.model.Cryptography;
import com.gustavoTBett.cryptography.repository.CryptographyRepository;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 *
 * @author gustavo
 */
@Service
public class CryptographyService {

    @Autowired
    private CryptographyRepository cryptographyRepository;

    //mudar o valor no application.properties
    @Value("${key.value}")
    private String SECRET_KEY;

    public Cryptography save(CryptographyDtoInsert CryptographyDtoInsert) throws NoSuchAlgorithmException, Exception {
        Cryptography cryptographyDb = new Cryptography();
        cryptographyDb.setUserDocument(encrypt(CryptographyDtoInsert.getUserDocument()));
        cryptographyDb.setCreditCardToken(encrypt(CryptographyDtoInsert.getCreditCardToken()));
        cryptographyDb.setValue(CryptographyDtoInsert.getValue());
        cryptographyDb = cryptographyRepository.save(cryptographyDb);
        return cryptographyDb;
    }

    public String encrypt(CharSequence rawPassword) {
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            SecretKeySpec secretKey = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] encryptedTextBytes = cipher.doFinal(rawPassword.toString().getBytes("UTF-8"));
            return Base64.getEncoder().encodeToString(encryptedTextBytes);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao criptografar a senha", e);
        }
    }

    public String decrypt(String encryptedPassword) {
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            SecretKeySpec secretKey = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] decryptedTextBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedPassword));
            return new String(decryptedTextBytes);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao descriptografar a senha", e);
        }
    }
}
