package com.applications.own.dataservices.persistence.repository;

import com.applications.own.dataservices.persistence.entity.SoupMenu;
import com.applications.own.dataservices.persistence.entity.TkmyordUser;
import com.applications.own.dataservices.util.DataServiceConstants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SoupDataRepository extends JpaRepository<SoupMenu, Integer> {
	SoupMenu findById(int id);

	@Query(value = DataServiceConstants.GET_REQ_SOUP_ID)
	List<SoupMenu> getReqSoupID(@Param("id") Integer id);
	
	@Query(value = DataServiceConstants.GET_SOUP_ID, nativeQuery = true)
	Integer getSoupId();
}
