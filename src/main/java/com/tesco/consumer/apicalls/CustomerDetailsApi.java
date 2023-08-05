package com.tesco.consumer.apicalls;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.tesco.consumer.model.EnquiryRequest;

@Component
public class CustomerDetailsApi {
	
	
	
	public ResponseEntity<String> cardCoustomerDetailsApiCall(EnquiryRequest enquiryRequest) {
		
	
		//rest api url
		String url = "http://localhost:9090/v1/enquiry/"+enquiryRequest.getPromocode();
		RestTemplate restTemplate = new RestTemplate(); 
		// set Headers of rest api url 
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("client_id", enquiryRequest.getClientId());
		headers.set("channel_id", enquiryRequest.getChannelId());
		headers.set("message_ts", enquiryRequest.getMessageTs());
		headers.set("request_id", enquiryRequest.getRequestId());
		
		HttpEntity<String> requestHeader = new HttpEntity(headers);
	//String response = 	restTemplate.getForObject(url, String.class); 
	ResponseEntity<String> response = 	restTemplate.exchange(url,HttpMethod.GET, requestHeader ,String.class); 
	
		
		return response;
}

}
