package com.ws.spring.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ws.common.util.StringUtil;
import com.ws.spring.model.EmeregencyDetails;
import com.ws.spring.model.UserDetails;
import com.ws.spring.repository.EmeregencyDetailsRepository;
import com.ws.spring.repository.UserRepository;
import com.ws.spring.sms.service.AppSmsSender;

@Service
public class EmeregencyDetailsService {

	Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	EmeregencyDetailsRepository removalDetailsRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	AppSmsSender appSmsSender;

	public EmeregencyDetails insert(EmeregencyDetails emeregencyDetails) {
		EmeregencyDetails details = removalDetailsRepository.save(emeregencyDetails);
		UserDetails userDetails = userRepository.findUserDetailsByMobileNumber(emeregencyDetails.getMobileNumber());
		try {
			if (null != userDetails && !StringUtil.checkNullOrEmpty(userDetails.getSecondaryMobileNumber()))
				appSmsSender.sendEmergencyNotificationSms(userDetails);
			else
				logger.warn("user Detail not found for the user mobile : {} ", emeregencyDetails.getMobileNumber());
		} catch (Exception ex) {
			logger.error("Exception Occure : {} ", ex.getMessage(), ex);
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Exception Occured", ex);
		}
		return details;
	}

	public EmeregencyDetails findById(Long id) {
		Optional<EmeregencyDetails> options = removalDetailsRepository.findById(id);
		return options.get();
	}

	public List<EmeregencyDetails> queryEmeregencyDetailsByMobileNumber(String mobileNumber) {
		return removalDetailsRepository.queryEmeregencyDetailsByMobileNumber(mobileNumber);
	}

	public List<EmeregencyDetails> queryEmeregencyDetailsByImei(String imei) {
		return removalDetailsRepository.queryEmeregencyDetailsByImei(imei);
	}
}
