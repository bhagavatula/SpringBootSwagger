package com.applications.own.dataservices.service;

import com.applications.own.dataservices.exception.TKORDSException;
import com.applications.own.dataservices.model.SoupBulkmenuData;
import com.applications.own.dataservices.model.SoupMenudataResponse;
import com.applications.own.dataservices.model.SoupmenuData;
import com.applications.own.dataservices.persistence.dao.SoupDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.misc.ExtensionInstallationException;

import java.util.List;

@Service
public class SoupServiceImpl implements SoupService {

	@Autowired
	SoupDAO soupDao;


	@Override
	public SoupMenudataResponse SaveSoupDetails(SoupmenuData soupmenuData) throws Exception {
		try {
			Integer soupId = soupDao.SaveSoupDetails(soupmenuData);
			SoupMenudataResponse soupMenudataResponse = new SoupMenudataResponse();
			soupMenudataResponse.setSoupId(soupId);
			return soupMenudataResponse;
		} catch (Exception e) {
			throw new Exception("Error while saving soup menu details in Service", e);
		}
	}

	@Override
	public SoupMenudataResponse SaveSoupBulkDetails(SoupBulkmenuData soupBulkmenuData) throws Exception {
		try{
			Integer soupIds = soupDao.SaveSoupBulkDetails(soupBulkmenuData);
			SoupMenudataResponse souprspne = new SoupMenudataResponse();
			souprspne.setSoupId(soupIds);
			return souprspne;
		}catch (Exception e){
			throw new TKORDSException("Error whlile saving soup bulk details in Service ",e);
		}
	}

	@Override
	public SoupMenudataResponse UpdateSoupDetails(SoupmenuData soupmenuData) throws Exception {
		return null;
	}

	@Override
	public List<SoupmenuData> getReqSoupData(int userId) throws Exception {
		return null;
	}
}
