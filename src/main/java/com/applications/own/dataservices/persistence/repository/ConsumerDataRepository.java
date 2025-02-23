package com.applications.own.dataservices.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.applications.own.dataservices.persistence.entity.TkmyordUser;
import com.applications.own.dataservices.util.DataServiceConstants;

@Repository
public interface ConsumerDataRepository extends JpaRepository<TkmyordUser, Integer> {
	TkmyordUser findById(int id);

	@Query(value = DataServiceConstants.GET_REGISTER_USER)
	List<TkmyordUser> getRegisterUser(@Param("id") Integer id);

	@Query(value = DataServiceConstants.GET_ALL_REGISTER_USERS)
	List<TkmyordUser> getAllRegisterUser();
	
	@Query(value = DataServiceConstants.GET_CONSUMER_ID, nativeQuery = true)
	Integer getConsumerId();

}
