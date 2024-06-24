package com.applications.own.dataservices.persistence.dao;

import com.applications.own.dataservices.model.SoupBulkmenuData;
import com.applications.own.dataservices.model.SoupmenuData;
import com.applications.own.dataservices.persistence.entity.SoupMenu;
import com.applications.own.dataservices.persistence.entity.TkmyordUser;
import com.applications.own.dataservices.persistence.repository.SoupDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Component
public class SoupDAOImpl implements SoupDAO {

	@Autowired
	SoupDataRepository soupDataRepository;

	@Override
	@Transactional
	public Integer SaveSoupDetails(SoupmenuData soupmenuData) throws Exception {
		try {
			// Below is to read the data from reqeust input
//			ConsumerData consumerData  = consumerDataInput.getConsumerData();
			// Now Map the Entity
			SoupMenu soupData = new SoupMenu();
			// Get the Consumer ID as it new Id for every insert
			Integer soupId = soupDataRepository.getSoupId();
			soupData.setId(soupId);
//			soupData.setId(soupData.getId());
			soupData.setName(soupmenuData.getName());
			soupData.setPrice(soupmenuData.getPrice());
			soupData.setType(soupmenuData.getType());
			// Save the consumer Data through repository
			soupDataRepository.save(soupData);
			return soupData.getId();
		} catch (Exception e) {
			String errorMessage = "Exception while saving the soup Data";
			throw new Exception("Error while saving SoupData", e);
		}

	}

	@Override
	public Integer SaveSoupBulkDetails(SoupBulkmenuData soupBulkmenuData) throws Exception {
		SoupMenu soupData = new SoupMenu();
		String soupIds=null;
		for(int itr =0; itr<soupBulkmenuData.size(); itr++){
			Integer soupId = soupDataRepository.getSoupId();
			soupIds+=","+soupId;
			soupData.setId(soupId);
			soupData.setName(soupBulkmenuData.get(itr).getName());
			soupData.setPrice(soupBulkmenuData.get(itr).getPrice());
			soupData.setType(soupBulkmenuData.get(itr).getType());
		}
	return Integer.valueOf(soupIds);
	}

	@Override
	public Integer UpdatedSoupDetails(SoupmenuData soupmenuData) throws Exception {
		try {
			 int id = soupmenuData.getId();
			 SoupMenu soupmenuDataRepo = soupDataRepository.findById(id);

			if (!(soupmenuDataRepo.getId() == null)) {
				soupmenuDataRepo.setId(soupmenuDataRepo.getId());
			}
			if (!(soupmenuDataRepo.getPrice() == null)) {
				soupmenuDataRepo.setPrice(soupmenuDataRepo.getPrice());
			}

			if (!(soupmenuDataRepo.getType() == null)) {
				soupmenuDataRepo.setType(soupmenuDataRepo.getType());
			}

			soupmenuDataRepo.setId(soupmenuData.getId());
			//Save the consumer Data through repository
		soupDataRepository.save(soupmenuDataRepo);
		return soupmenuDataRepo.getId();
	}catch (Exception e) {
			String errorMessage = "Exception while saving the consumer Data";
			throw new Exception("Error while saving ConsumerData", e);
		}
}

	@Override
	public List<SoupmenuData> getReqSoupData(int soupId) throws Exception {
		SoupmenuData soupData = new SoupmenuData();
		List<SoupMenu> SoupDtls = soupDataRepository.getReqSoupID(soupId);
		List<SoupmenuData> soupDtlsList = new ArrayList<>();
		try {
			if (!SoupDtls.isEmpty()) {
				soupData.setId(SoupDtls.get(0).getId());
				soupData.setPrice(SoupDtls.get(0).getPrice());
				soupData.setName(SoupDtls.get(0).getName());
				soupData.setType(SoupDtls.get(0).getType());
			soupDtlsList.add(soupData);
		}
		return soupDtlsList;
		}
		catch (Exception e) {
			String errorMessage = "Exception Fetching the consumer data from SoupMenu Table";
			throw new Exception(errorMessage,e);
		}
	}
 }