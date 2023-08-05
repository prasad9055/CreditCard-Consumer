package com.tesco.consumer.service;

import org.springframework.http.ResponseEntity;

import com.tesco.consumer.model.EnquiryRequest;

public interface ICreditCardConsumerService {

	public String cardCoustomerDetails(EnquiryRequest enquiryRequest) ;
}
