package com.applications.own.dataservices.persistence.dao;

import java.util.List;

import com.applications.own.dataservices.model.ConsumerBulkData;
import com.applications.own.dataservices.model.ConsumerData;
import com.applications.own.dataservices.model.ConsumerDataResponse;
import com.applications.own.dataservices.persistence.entity.TkmyordUser;
import org.springframework.http.HttpStatus;

public interface ConsumerDAO {

	Integer SaveConsumerDetails(ConsumerData consumberData) throws Exception;
	Integer SaveConsumerBulkDetails(ConsumerBulkData consumberBulkData) throws Exception;
	Integer UpdatedConsumerDetails(ConsumerData consumberData) throws Exception;
	List<ConsumerData> getRegisterdConsumerData(int userId) throws Exception;
	List<String> getAllCustomerData() throws Exception;

}
