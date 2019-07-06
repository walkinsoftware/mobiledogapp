package com.ws.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ws.spring.model.EmeregencyDetails;

@Repository
public interface EmeregencyDetailsRepository extends JpaRepository<EmeregencyDetails, Long> {

	@Query("Select e from EmeregencyDetails e where e.mobileNumber = :mobileNumber")
	List<EmeregencyDetails> queryEmeregencyDetailsByMobileNumber(@Param("mobileNumber") String mobileNumber);

	@Query("Select e from EmeregencyDetails e where e.imeiNum = :imeiNum")
	List<EmeregencyDetails> queryEmeregencyDetailsByImei(@Param("imeiNum") String imeiNum);
}
