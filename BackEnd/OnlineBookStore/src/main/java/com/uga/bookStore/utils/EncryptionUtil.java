package com.uga.bookStore.utils;


import java.nio.charset.StandardCharsets;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.stereotype.Component;

@Component
public class EncryptionUtil {
	private String secretKey = "1234567891234567";
	private String initVector = "9876543212345678";
	private String algo = "AES/CBC/PKCS5PADDING";

	public String encryptMethod(String cardNumber) {
		String encryptedString = null;
		try {
			IvParameterSpec iv = new IvParameterSpec(initVector.getBytes(StandardCharsets.UTF_8));
			SecretKeySpec skeySpec = new SecretKeySpec(secretKey.getBytes(StandardCharsets.UTF_8), "AES");

			Cipher cipher = Cipher.getInstance(algo);
			cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

			byte[] encrypted = cipher.doFinal(cardNumber.getBytes());
			encryptedString = Base64.getEncoder().encodeToString(encrypted);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return encryptedString;
	}

	public String decryptMethod(String encryptedString) {

		String decryptedString = null;
		try {
			IvParameterSpec ivParameterSpec = new IvParameterSpec(initVector.getBytes(StandardCharsets.UTF_8));
			SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(StandardCharsets.UTF_8), "AES");

			Cipher cipher = Cipher.getInstance(algo);
			cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);

			byte[] original = cipher.doFinal(Base64.getDecoder().decode(encryptedString));
			decryptedString = new String(original);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return decryptedString;
	}

}
