package com.ws.spring.repository;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ws.spring.model.UserDetails;

@Repository
public interface UserRepository extends JpaRepository<UserDetails, Long> {

	// https://www.baeldung.com/spring-data-jpa-query
	// @Query("SELECT u FROM User u WHERE u.nameUser = ?1")
	@Query("SELECT u FROM UserDetails u WHERE u.userName = :userName")
	UserDetails findUserDetailsByUserName(@Param("userName") String userName);

	@Query("SELECT u FROM UserDetails u WHERE u.emailId = :emailId")
	UserDetails findUserDetailsByEmailId(@Param("emailId") String emailId);

	@Query("SELECT u FROM UserDetails u WHERE u.mobileNumber = :mobileNumber")
	UserDetails findUserDetailsByMobileNumber(@Param("mobileNumber") String mobileNumber);

	@Query("SELECT u FROM UserDetails u WHERE u.userName = :userName or u.emailId = :userName or u.mobileNumber = :userName")
	UserDetails queryLoginUserDetails(@Param("userName") String userName);

	@Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM UserDetails u WHERE (u.isActive = 0 or u.isActive = 1) and u.barcode = :barcode")
	Boolean isBarCodeExist(String barcode);

	@Query("SELECT u FROM UserDetails u WHERE u.isActive = 0")
	List<UserDetails> queryRegisteredUsers();

	long countByIsActive(int isActive);

	@Modifying(clearAutomatically = true)
	@Transactional
	@Query("UPDATE UserDetails u set u.approveStatus = :approveStatus, u.isActive = :isActive, u.reason = :reason where u.id in :userIds")
	void updateUserActivation(@Param("userIds") Set<Long> userIds, @Param("approveStatus") int approveStatus,
			@Param("isActive") int isActive, @Param("reason") String reason);

	@Modifying(clearAutomatically = true)
	@Transactional
	@Query("UPDATE UserDetails u set u.mpin = :mpin where u.userName = :userName")
	void updateMpin(@Param("userName") String userName, @Param("mpin") String mpin);

	@Query("SELECT u FROM UserDetails u WHERE u.userName LIKE :userName or u.fullName LIKE :userName and u.mobileNumber LIKE :mobileNumber")
	List<UserDetails> queryUserDetailsByUserNameOrMobile(@Param("userName") String userName,
			@Param("mobileNumber") String mobileNumber);

	@Query("SELECT u FROM UserDetails u WHERE u.insertedDate between :fromDate and :toDate")
	List<UserDetails> queryUserListByInsertedDate(@Param("fromDate") Date fromDate, @Param("toDate") Date toDate);

	@Query("SELECT u FROM UserDetails u WHERE u.isActive = :isActive and u.insertedDate between :fromDate and :toDate")
	List<UserDetails> queryUserListByIsActiveAndInsertedDate(@Param("isActive") int isActive,
			@Param("fromDate") Date fromDate, @Param("toDate") Date toDate);

	@Query("SELECT u FROM UserDetails u WHERE u.isActive = :isActive")
	List<UserDetails> queryUserListByIsActive(@Param("isActive") int isActive);
	
	@Query("SELECT u FROM UserDetails u")
	List<UserDetails> queryAllUserList();

}
