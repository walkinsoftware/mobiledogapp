package com.ws.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ws.spring.model.EmeregencyDetails;
import com.ws.spring.model.UserDetails;
import com.ws.spring.repository.EmeregencyDetailsRepository;
import com.ws.spring.repository.UserRepository;
import com.ws.spring.sms.service.AppSmsSender;

@Service
public class EmeregencyDetailsService {

	@Autowired
	EmeregencyDetailsRepository removalDetailsRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	AppSmsSender appSmsSender;

	public EmeregencyDetails insert(EmeregencyDetails emeregencyDetails) {
		EmeregencyDetails details = removalDetailsRepository.save(emeregencyDetails);
		UserDetails userDetails = userRepository.findUserDetailsByMobileNumber(emeregencyDetails.getMobileNumber());
		appSmsSender.sendEmergencyNotificationSms(userDetails);
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
