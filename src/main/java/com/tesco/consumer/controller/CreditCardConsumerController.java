package com.tesco.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tesco.consumer.model.EnquiryRequest;
import com.tesco.consumer.service.ICreditCardConsumerService;


@RestController
@RequestMapping("/v")
public class CreditCardConsumerController {
	@Autowired
	ICreditCardConsumerService icreditCardConsumerService ;
	
	@PostMapping("/customer-info/{promocode}")
	@ResponseBody
	public ResponseEntity<String> getPromoDetails(@PathVariable("promocode") String promocode,
			 @RequestHeader("client_id") String client_id ,
             @RequestHeader("channel_id") String channel_id ,
             @RequestHeader("message_ts") String messageTimeStamp ,
             @RequestHeader("request_id") String request_id ) {

		EnquiryRequest enquiryRequest = new EnquiryRequest();
		enquiryRequest.setPromocode(promocode);
		enquiryRequest.setClientId(client_id);
		enquiryRequest.setChannelId(channel_id);
		enquiryRequest.setRequestId(request_id);
		enquiryRequest.setMessageTs(messageTimeStamp);
		
		String response = icreditCardConsumerService.cardCoustomerDetails(enquiryRequest);
		ResponseEntity<String> res = new ResponseEntity<String>(response, HttpStatus.OK);
		
		return res;
	}

}
