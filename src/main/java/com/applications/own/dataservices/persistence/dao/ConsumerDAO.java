package com.applications.own.dataservices.persistence.dao;

import java.util.List;

import com.applications.own.dataservices.model.ConsumerData;
import com.applications.own.dataservices.model.ConsumerDataResponse;
import com.applications.own.dataservices.persistence.entity.TkmyordUser;

public interface ConsumerDAO {
	
	Integer SaveConsumerDetails(ConsumerData consumberData) throws Exception;
	Integer UpdatedConsumerDetails(ConsumerData consumberData) throws Exception;
	List<ConsumerData> getRegisterdConsumerData(int userId) throws Exception;

}
