package com.applications.own.dataservices.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.applications.own.dataservices.model.ConsumerData;
import com.applications.own.dataservices.model.ConsumerDataResponse;
import com.applications.own.dataservices.persistence.dao.ConsumerDAO;
import com.applications.own.dataservices.persistence.entity.TkmyordUser;
import com.applications.own.dataservices.persistence.repository.ConsumerDataRepository;

import ch.qos.logback.classic.Logger;

@Service
public class ConsumerServiceImpl implements ConsumerService {

	@Autowired
	private ConsumerDAO consumerDAO;

	public ConsumerDataResponse SaveConsumerDetails(ConsumerData consumerdata) throws Exception {
		try {
			Integer taskId = consumerDAO.SaveConsumerDetails(consumerdata);
			ConsumerDataResponse consumderResponse = new ConsumerDataResponse();
			consumderResponse.setUserId(taskId);
			return consumderResponse;
		} catch (Exception e) {
			throw new Exception("Error while saving consumer details in Service", e);
		}

	}

	@Override
	public ConsumerDataResponse UpdateConsumerDetails(ConsumerData consumerdata) throws Exception {
		try {
			Integer taskId = consumerDAO.UpdatedConsumerDetails(consumerdata);
			ConsumerDataResponse consumderResponse = new ConsumerDataResponse();
			consumderResponse.setUserId(taskId);
			return consumderResponse;
		} catch (Exception e) {
			throw new Exception("Error while saving consumer details in Service", e);
		}
	}

	@Override
	public List<ConsumerData> getRegisterdConsumerData(int userId) throws Exception  {
		List<ConsumerData> tkmyOrdUsersData = consumerDAO.getRegisterdConsumerData(userId);
		return tkmyOrdUsersData;
		
	}

}
