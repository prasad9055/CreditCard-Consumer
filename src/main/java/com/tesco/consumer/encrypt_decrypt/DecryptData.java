package com.tesco.consumer.encrypt_decrypt;

import java.io.InputStream;
import java.security.Key;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import org.jboss.resteasy.jose.jwe.JWEBuilder;
import org.jboss.resteasy.jose.jwe.JWEInput;
import org.springframework.stereotype.Component;

@Component
public class DecryptData {
	
	public String StringToDecrypt(String data) {
		
		  String decryptedData="";
	          try {
				
	        		InputStream jks = this.getClass().getClassLoader().getResourceAsStream("hdfc.jks");
	        		KeyStore keystore = KeyStore.getInstance(KeyStore.getDefaultType());
	        		String password = "hdfcpass";
	        		char[] passwd = password.toCharArray();
	        		keystore.load(jks, passwd);
	        		String alias = "hdfc";
	        		Key key = keystore.getKey(alias, passwd);
	        		if (key instanceof PrivateKey) {
	        	    byte[] raw = new JWEInput(data).decrypt((RSAPrivateKey)key).getRawContent();
	                 decryptedData = new String(raw);
	                System.out.println(decryptedData);
	        		}	       
	        	  
			} catch (Exception e) {
				// TODO: handle exception
			}
	          return decryptedData ;
	}

}
