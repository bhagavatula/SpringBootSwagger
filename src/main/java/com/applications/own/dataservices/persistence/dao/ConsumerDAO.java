package com.applications.own.dataservices.persistence.dao;

import java.util.List;

import com.applications.own.dataservices.exception.TKORDSException;
import com.applications.own.dataservices.model.ConsumerBulkData;
import com.applications.own.dataservices.model.ConsumerData;
import com.applications.own.dataservices.persistence.entity.TkmyordUser;

public interface ConsumerDAO {

	Integer SaveConsumerDetails(ConsumerData consumberData) throws TKORDSException;
	Integer SaveConsumerBulkDetails(ConsumerBulkData consumberBulkData) throws Exception;
	Integer UpdatedConsumerDetails(ConsumerData consumberData) throws Exception;
	List<ConsumerData> getRegisterdConsumerData(int userId) throws Exception;
	List<TkmyordUser> getAllCustomerData() throws Exception;

}
