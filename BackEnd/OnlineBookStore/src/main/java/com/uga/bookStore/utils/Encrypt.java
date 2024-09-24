package com.uga.bookStore.utils;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.AttributeConverter;

public class Encrypt implements AttributeConverter<String, String>{

	@Autowired
	EncryptionUtil encryptionUtil;
	@Override
	public String convertToDatabaseColumn(String attribute) {
		return encryptionUtil.encryptMethod(attribute);
	}

	@Override
	public String convertToEntityAttribute(String dbData) {
		return encryptionUtil.decryptMethod(dbData);
	}
	

}