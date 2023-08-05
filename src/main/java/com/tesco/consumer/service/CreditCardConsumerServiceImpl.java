package com.tesco.consumer.service;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.tesco.consumer.apicalls.CustomerDetailsApi;
import com.tesco.consumer.encrypt_decrypt.DecryptData;
import com.tesco.consumer.model.EnquiryRequest;


@Service
public class CreditCardConsumerServiceImpl implements ICreditCardConsumerService {
	

//private	RestTemplate restTemplate;
    @Autowired
	CustomerDetailsApi customerDetailsApi;
    @Autowired
    DecryptData decryptData;
	
	public String cardCoustomerDetails(EnquiryRequest enquiryRequest) {
		
	ResponseEntity<String> response =	customerDetailsApi.cardCoustomerDetailsApiCall(enquiryRequest);
     String data = response.getBody();
     System.out.println("=====Encrypted Data==================");
     System.out.println(data);
     String jsonData =  decryptData.StringToDecrypt(data);
  
		return jsonData;
}
}