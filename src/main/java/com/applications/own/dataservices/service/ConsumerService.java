package com.applications.own.dataservices.service;

import java.util.List;

import com.applications.own.dataservices.model.ConsumerData;
import com.applications.own.dataservices.model.ConsumerDataResponse;

public interface ConsumerService {

	ConsumerDataResponse  SaveConsumerDetails(ConsumerData consumerdata) throws Exception;
	ConsumerDataResponse  UpdateConsumerDetails(ConsumerData consumerdata) throws Exception;
	List<ConsumerData> getRegisterdConsumerData(int userId) throws Exception;
	
}
