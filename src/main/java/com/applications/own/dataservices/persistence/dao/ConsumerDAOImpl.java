package com.applications.own.dataservices.persistence.dao;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.applications.own.dataservices.model.ConsumerData;
import com.applications.own.dataservices.model.ConsumerDataResponse;
import com.applications.own.dataservices.persistence.entity.TkmyordUser;
import com.applications.own.dataservices.persistence.repository.ConsumerDataRepository;

@Component
public class ConsumerDAOImpl implements ConsumerDAO {

//	@Autowired
//	private TkmyordUser consumerRegister;
//	
	@Autowired
	ConsumerDataRepository consumerDataRepository;

	@Override
	@Transactional
	public Integer SaveConsumerDetails(ConsumerData consumerData) throws Exception {
		try {
			// Below is to read the data from reqeust input
//			ConsumerData consumerData  = consumerDataInput.getConsumerData();
			// Now Map the Entity
			TkmyordUser consumerRegister = new TkmyordUser();
			// Get the Consumer ID as it new Id for every insert
			Integer consumerID = consumerDataRepository.getConsumerId();
			consumerRegister.setAge(consumerData.getAge());
			consumerRegister.setDateofbirth(new java.sql.Date(consumerData.getDateofbirth().getTime()));
			consumerRegister.setDeliveryAddress(consumerData.getAddress());
			consumerRegister.setFirstName(consumerData.getFirstname());
			consumerRegister.setLastName(consumerData.getLastname());
			consumerRegister.setSex(consumerData.getSex());
			consumerRegister.setZipcode(consumerData.getZipcode());
			consumerRegister.setId(consumerID);
			// Save the consumer Data through repository

			consumerDataRepository.save(consumerRegister);
			return consumerRegister.getId();
		} catch (Exception e) {
			String errorMessage = "Exception while saving the consumer Data";
			throw new Exception("Error while saving ConsumerData", e);
		}

	}

	@Override
	public Integer UpdatedConsumerDetails(ConsumerData consumerData) throws Exception {
		try {
			 int id = consumerData.getId();
			TkmyordUser consumerRegister = consumerDataRepository.findById(id);
		 
			if (!(consumerData.getAge() == null)) {
				consumerRegister.setAge(consumerData.getAge());
			}
			if (!(consumerData.getDateofbirth() == null)) {
				consumerRegister.setDateofbirth(new java.sql.Date(consumerData.getDateofbirth().getTime()));
			}
			if (!(consumerData.getAddress() == null)) {
				consumerRegister.setDeliveryAddress(consumerData.getAddress());
			}
			if (!(consumerData.getFirstname() == null)) {
				consumerRegister.setFirstName(consumerData.getFirstname());
			}
			if (!(consumerData.getLastname() == null)) {
				consumerRegister.setLastName(consumerData.getLastname());
			}
			if (!(consumerData.getSex() == null)) {
				consumerRegister.setSex(consumerData.getSex());
			}
			if (!(consumerData.getAge() == null)) {
				consumerRegister.setZipcode(consumerData.getZipcode());
			}
			consumerRegister.setId(consumerData.getId());
			//Save the consumer Data through repository
		consumerDataRepository.save(consumerRegister);
		return consumerData.getId();
	}catch (Exception e)
	{
		String errorMessage = "Exception while saving the consumer Data";
		throw new Exception ("Error while saving ConsumerData",e);
	}
}

	@Override
	public List<ConsumerData> getRegisterdConsumerData(int userId) throws Exception {
		ConsumerData consumerData = new ConsumerData();
		List<TkmyordUser> tkmyOrdUsersData = consumerDataRepository.getRegisterUser(userId);
		List<ConsumerData> consumerdataList = new ArrayList<>();
		try {
			if (!tkmyOrdUsersData.isEmpty()) {
				consumerData.setAddress(tkmyOrdUsersData.get(0).getDeliveryAddress());
				consumerData.setAge(tkmyOrdUsersData.get(0).getAge());
				consumerData.setDateofbirth(tkmyOrdUsersData.get(0).getDateofbirth());
				consumerData.setFirstname(tkmyOrdUsersData.get(0).getFirstName());
				consumerData.setLastname(tkmyOrdUsersData.get(0).getLastName());
				consumerData.setId(tkmyOrdUsersData.get(0).getId());
				consumerData.setSex(tkmyOrdUsersData.get(0).getSex());
				consumerData.setZipcode(tkmyOrdUsersData.get(0).getZipcode());
				consumerdataList.add(consumerData);
			}
		return consumerdataList;	
		} catch (Exception e) {
			String errorMessage = "Exceptiopn Fetching the consumer data from TkmyordUser Table";
			throw new Exception(errorMessage,e);
		}
	}

}
