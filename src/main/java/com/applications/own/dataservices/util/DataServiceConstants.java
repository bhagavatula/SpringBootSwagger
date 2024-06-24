package com.applications.own.dataservices.util;

public class DataServiceConstants {

	public static final String GET_CONSUMER_ID  = "SELECT nextval('tkmyord_user_dtls_sequence')";
	public static final String SELECT_MY_ORD_USER = "SELECT t FROM TkmyordUser t";
	public static final String GET_REGISTER_USER = SELECT_MY_ORD_USER +" WHERE id=:id";
	public static final String GET_ALL_REGISTER_USERS = "SELECT CONCAT(first_name, ' ', last_name) FROM TkmyordUser";
	public static final String GET_SOUP_ID  = "SELECT nextval('soup_id_dtls_sequence')";
	public static final String SELECT_SOUP_DTLS = "SELECT sp FROM SoupMenu sp";
	public static final String GET_REQ_SOUP_ID = SELECT_SOUP_DTLS +" WHERE id=:id";
	public static final String GET_ALL_SOUP_DTLS = "SELECT type FROM SoupMenu";

			

}
