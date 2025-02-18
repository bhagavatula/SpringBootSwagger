package com.applications.own.dataservices.persistence.dao;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.applications.own.dataservices.exception.EmailCheckException;
import com.applications.own.dataservices.exception.ErrorList;
import com.applications.own.dataservices.exception.TKORDSException;
import com.applications.own.dataservices.model.ConsumerBulkData;
import com.applications.own.dataservices.model.ErrorResponse;
//import com.sun.javaws.exceptions.ErrorCodeResponseException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.applications.own.dataservices.model.ConsumerData;
import com.applications.own.dataservices.model.ConsumerDataResponse;
import com.applications.own.dataservices.persistence.entity.TkmyordUser;
import com.applications.own.dataservices.persistence.repository.ConsumerDataRepository;

@Log4j2
@Component
public class ConsumerDAOImpl implements ConsumerDAO {

//	@Autowired
//	private TkmyordUser consumerRegister;
//	
	@Autowired
	ConsumerDataRepository consumerDataRepository;
	
//	@Autowired
//    private ErrorList errorList;

	@Override
	@Transactional
	public Integer SaveConsumerDetails(ConsumerData consumerData) throws TKORDSException {
//		try {
			List<TkmyordUser> userdata = consumerDataRepository.findAll();
			ErrorResponse errorResponse = new ErrorResponse();
			List<ErrorResponse> errorResponses = new ArrayList<>();
			// Below is to read the data from reqeust input
//			ConsumerData consumerData  = consumerDataInput.getConsumerData();
			// Now Map the Entity
			TkmyordUser consumerRegister = new TkmyordUser();
			// Get the Consumer ID as it new Id for every insert
//			Integer consumerID = consumerDataRepository.getConsumerId();
			if((consumerData.getFirstname() == null) || ((consumerData.getFirstname().trim().equals("")))){
				throw new TKORDSException  ("Error while saving the User Information: User Name not Available in consumerData");
			}
			if (userdata.stream().filter(userrecord -> userrecord.getEmail().contentEquals(consumerData.getEmail())).findFirst().isPresent()){
//				throw new TKORDSException ("Error while saving ConsumerBulkData"+consumerData.getEmail()+" Alreday registered Email!");
				;
				errorResponse.setErrorCode(HttpStatus.CONFLICT.toString());
				errorResponse.setErrorMessage("Error while saving "+consumerData.getEmail()+" Already registered Email!");
				List<ErrorResponse> errorResponseList = new ArrayList<ErrorResponse>();
				errorResponseList.add(errorResponse);
				ErrorList errorList = new ErrorList(errorResponseList);
				TKORDSException tkordSException = new TKORDSException();
				tkordSException.setErrorList(errorList);
				throw tkordSException;
			}
			consumerRegister.setAge(consumerData.getAge());
			consumerRegister.setDateofbirth(new java.sql.Date(consumerData.getDateofbirth().getTime()));
			consumerRegister.setDeliveryAddress(consumerData.getAddress());
			consumerRegister.setFirstName(consumerData.getFirstname());
			consumerRegister.setLastName(consumerData.getLastname());
			consumerRegister.setSex(consumerData.getSex());
			consumerRegister.setZipcode(consumerData.getZipcode());
//			consumerRegister.setId(consumerID);
			// Save the consumer Data through repository
//			consumerDataRepository.save(consumerRegister);
			return consumerDataRepository.save(consumerRegister).getId();
//			return HttpStatus.ACCEPTED;
//			egistration is fuccessful";
//		} catch (Exception e) {
//			String errorMessage = "Exception while saving the consumer Data";
////			throw new Exception("Error while saving ConsumerData", e);
////			throw new TKORDSException  ("Error while saving the User Information");
//			throw new TKORDSException();
//		}
	}

	@Override
	@Transactional
	public Integer SaveConsumerBulkDetails(ConsumerBulkData consumerBulkData) throws Exception {
		TkmyordUser consumerRegister = new TkmyordUser();
		String consumerIDs= "";
		List<TkmyordUser> userList = new ArrayList<>();
		try{
		for (int itr= 0; itr<consumerBulkData.size(); itr++){
//			Integer consumerID = consumerDataRepository.getConsumerId();
//			consumerIDs+=consumerID;
			//log.info(itr);
			consumerRegister.setAge(consumerBulkData.get(itr).getAge());
			consumerRegister.setDateofbirth(new java.sql.Date(consumerBulkData.get(itr).getDateofbirth().getTime()));
			consumerRegister.setDeliveryAddress(consumerBulkData.get(itr).getAddress());
			consumerRegister.setFirstName(consumerBulkData.get(itr).getFirstname());
			consumerRegister.setLastName(consumerBulkData.get(itr).getLastname());
			consumerRegister.setSex(consumerBulkData.get(itr).getSex());
			consumerRegister.setZipcode(consumerBulkData.get(itr).getZipcode());
			userList.add(consumerRegister);
		}
			consumerDataRepository.saveAll(userList);
		return Integer.valueOf(200);
	} catch (Exception e) {
		String errorMessage = "Exception while saving the consumer Bulk Data";
		throw new Exception("Error while saving ConsumerBulkData", e);
	}
	}

	@Override
	public Integer UpdatedConsumerDetails(ConsumerData consumerData) throws Exception {
		try {
			 int id = consumerData.getId();
			TkmyordUser consumerRegister = consumerDataRepository.findById(id);

			if (consumerData.getAge()!= null) {
				consumerRegister.setAge(consumerData.getAge());
			}
			if (consumerData.getDateofbirth() != null) {
				consumerRegister.setDateofbirth(new java.sql.Date(consumerData.getDateofbirth().getTime()));
			}
			if (consumerData.getAddress() != null) {
				consumerRegister.setDeliveryAddress(consumerData.getAddress());
			}
			if (consumerData.getFirstname() != null) {
				consumerRegister.setFirstName(consumerData.getFirstname());
			}
			if (consumerData.getLastname() != null) {
				consumerRegister.setLastName(consumerData.getLastname());
			}
			if (consumerData.getSex() != null) {
				consumerRegister.setSex(consumerData.getSex());
			}
			if (consumerData.getAge() != null) {
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

	@Override
	public List<String> getAllCustomerData() throws Exception {
		List<String> allConsumerData = consumerDataRepository.getAllRegisterUser();
		return allConsumerData;
	}

}
