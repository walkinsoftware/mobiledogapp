package com.ws.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ws.spring.model.EmeregencyDetails;
import com.ws.spring.repository.EmeregencyDetailsRepository;

@Service
public class EmeregencyDetailsService {

	@Autowired
	EmeregencyDetailsRepository removalDetailsRepository;

	public EmeregencyDetails insert(EmeregencyDetails EmeregencyDetails) {
		return removalDetailsRepository.save(EmeregencyDetails);
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
