package com.applications.own.dataservices.util;

public class DataServiceConstants {

	public static final String GET_CONSUMER_ID  = "SELECT nextval('tkmyord_user_dtls_sequence')";
	public static final String SELECT_MY_ORD_USER = "SELECT t FROM TkmyordUser t";
	public static final String GET_REGISTER_USER = SELECT_MY_ORD_USER +" WHERE id=:id";
			
			

}
