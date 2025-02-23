package com.applications.own.dataservices.service;

import java.util.List;

import com.applications.own.dataservices.exception.TKORDSException;
import com.applications.own.dataservices.model.ConsumerBulkData;
import com.applications.own.dataservices.model.ConsumerData;
import com.applications.own.dataservices.model.ConsumerDataResponse;
import com.applications.own.dataservices.persistence.entity.TkmyordUser;

public interface ConsumerService {

	ConsumerDataResponse  SaveConsumerDetails(ConsumerData consumerdata) throws TKORDSException;
	ConsumerDataResponse SaveConsumerBulkDetails(ConsumerBulkData consumerBulkData) throws Exception;
	ConsumerDataResponse  UpdateConsumerDetails(ConsumerData consumerdata) throws Exception;
	List<ConsumerData> getRegisterdConsumerData(int userId) throws Exception;
	List<TkmyordUser> getAllCustomerData() throws Exception;
	
}
