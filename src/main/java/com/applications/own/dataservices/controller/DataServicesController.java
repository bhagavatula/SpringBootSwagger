package com.applications.own.dataservices.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.applications.own.dataservices.model.ConsumerData;
import com.applications.own.dataservices.model.ConsumerDataResponse;
import com.applications.own.dataservices.service.ConsumerService;


@RestController
public class DataServicesController {
	
	private static final Logger LOGGER =LoggerFactory.getLogger(DataServicesController.class);
	
	@Autowired
	private ConsumerService consumerService;
	
	@GetMapping("/health")
	@ResponseStatus(HttpStatus.OK)	
	public ResponseEntity<String> health(){
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping(value = "/consumerdata", consumes = "application/json", produces = "application/json")
	public ResponseEntity<ConsumerDataResponse> registerConsumerData(@RequestBody ConsumerData consumerdata) throws Exception{		 
		ConsumerDataResponse consumerDataResponse = consumerService.SaveConsumerDetails(consumerdata);
		return new ResponseEntity(consumerDataResponse.getUserId(), HttpStatus.OK);
	
	}
	
	@PutMapping(value = "/updateconsumerdata", consumes = "application/json", produces = "application/json")
	public ResponseEntity<ConsumerDataResponse> updateConsumerData(@RequestBody ConsumerData consumerdata) throws Exception{		 
		ConsumerDataResponse consumerDataResponse = consumerService.UpdateConsumerDetails(consumerdata);
		return new ResponseEntity(consumerDataResponse.getUserId(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/consumers/{userId}", produces = "application/json")
	public ResponseEntity<List<ConsumerDataResponse>> getRegisterdConsumerData(@PathVariable("userId") Integer userId) throws Exception{		 
		List<ConsumerData> consumerDataResponse = consumerService.getRegisterdConsumerData(userId);
		return new ResponseEntity(consumerDataResponse, HttpStatus.OK);
	}
	
}
