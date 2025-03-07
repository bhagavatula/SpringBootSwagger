package com.applications.own.dataservices.controller;

import java.util.List;

import com.applications.own.dataservices.exception.ErrorList;
import com.applications.own.dataservices.exception.TKORDSException;
import com.applications.own.dataservices.model.*;
import com.applications.own.dataservices.persistence.entity.TkmyordUser;
import com.applications.own.dataservices.service.SoupService;
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

import com.applications.own.dataservices.service.ConsumerService;


@RestController
public class DataServicesController {
	
	private static final Logger LOGGER =LoggerFactory.getLogger(DataServicesController.class);
	
	@Autowired
	private ConsumerService consumerService;

	@Autowired
	private SoupService soupService;

	@Autowired
	TKORDSException tkordsException;

	@Autowired
	ErrorList errorList;

	@GetMapping("/health")
	@ResponseStatus(HttpStatus.OK)	
	public ResponseEntity<String> health(){
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping(value = "/consumerdata", consumes = "application/json", produces = "application/json")
	public ResponseEntity<ConsumerDataResponse> registerConsumerData(@RequestBody ConsumerData consumerdata) throws Exception{
		try {
			ConsumerDataResponse consumerDataResponse = consumerService.SaveConsumerDetails(consumerdata);
			return new ResponseEntity(consumerDataResponse, HttpStatus.CREATED);
		}catch (TKORDSException e){
//			System.out.println(tkordsException.getErrorList());
			return new ResponseEntity(e.getErrorList() ,HttpStatus.CONFLICT);
		}
	}

	@PostMapping(value = "/consumerBulkdata", consumes = "application/json", produces = "application/json")
	public ResponseEntity<ConsumerDataResponse> registerConsumerBulkData(@RequestBody ConsumerBulkData consumerBulkdata) throws Exception{
		ConsumerDataResponse consumerDataResponse = consumerService.SaveConsumerBulkDetails(consumerBulkdata);
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

	@GetMapping(value = "/allconsumers/", produces = "application/json")
	public ResponseEntity<List<TkmyordUser>> getAllRegisterdConsumerData() throws Exception{
		List<TkmyordUser> allconsumerResponse = consumerService.getAllCustomerData();
		return new ResponseEntity(allconsumerResponse, HttpStatus.OK);
	}

	@PostMapping(value = "/soupdata", consumes = "application/json", produces = "application/json")
	public ResponseEntity<SoupMenudataResponse> registerSoupData(@RequestBody SoupmenuData soupData) throws Exception{
		SoupMenudataResponse soupMenudataResponse = soupService.SaveSoupDetails(soupData);
		return new ResponseEntity(soupMenudataResponse.getsoupId(), HttpStatus.OK);
	}

	@PostMapping(value = "/soupBulkData", consumes = "application/json", produces = "application/json")
	public ResponseEntity<ConsumerDataResponse> registerSoupBulkData(@RequestBody SoupBulkmenuData soupbulkmenudata) throws Exception{
		SoupMenudataResponse soupBulkMenudataResponse = soupService.SaveSoupBulkDetails(soupbulkmenudata);
		return new ResponseEntity(soupBulkMenudataResponse.getsoupId(), HttpStatus.OK);
	}
	
}
