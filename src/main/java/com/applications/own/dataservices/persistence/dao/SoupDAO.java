package com.applications.own.dataservices.persistence.dao;

import com.applications.own.dataservices.model.ConsumerBulkData;
import com.applications.own.dataservices.model.SoupBulkmenuData;
import com.applications.own.dataservices.model.SoupmenuData;

import java.util.List;

public interface SoupDAO {
	
	Integer SaveSoupDetails(SoupmenuData soupmenuData) throws Exception;
	Integer SaveSoupBulkDetails(SoupBulkmenuData soupBulkmenuData) throws Exception;
	Integer UpdatedSoupDetails(SoupmenuData soupmenuData) throws Exception;
	List<SoupmenuData> getReqSoupData(int soupId) throws Exception;

}
