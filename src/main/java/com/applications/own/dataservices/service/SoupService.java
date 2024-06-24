package com.applications.own.dataservices.service;

import com.applications.own.dataservices.model.*;

import java.util.List;

public interface SoupService {

	SoupMenudataResponse  SaveSoupDetails(SoupmenuData soupmenuData) throws Exception;
	SoupMenudataResponse SaveSoupBulkDetails(SoupBulkmenuData soupBulkmenuData) throws Exception;
	SoupMenudataResponse UpdateSoupDetails(SoupmenuData soupmenuData) throws Exception;
	List<SoupmenuData> getReqSoupData(int soupId) throws Exception;
	
}
