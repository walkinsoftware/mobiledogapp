package com.ws.spring.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.mail.util.BASE64EncoderStream;
import com.ws.spring.dto.SimRemovalDto;
import com.ws.spring.model.EmeregencyDetails;
import com.ws.spring.model.GpsTrackingDetails;
import com.ws.spring.model.SimRemovalDetails;
import com.ws.spring.repository.EmeregencyDetailsRepository;
import com.ws.spring.repository.GpsTrackingRepository;
import com.ws.spring.repository.SimRemovalDetailsRepository;

@Service
public class GpsTrackingService {

	Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	GpsTrackingRepository gpsTrackingRepository;

	@Autowired
	SimRemovalDetailsRepository simRemovalDetailsRepository;

	@Autowired
	EmeregencyDetailsRepository emeregencyDetailsRepository;

	public void addUserGpsTrackingDetails(GpsTrackingDetails userGpsTrackingDetails) {
		gpsTrackingRepository.save(userGpsTrackingDetails);
	}

	public List<GpsTrackingDetails> queryUserGpsTrackingDetails(String mobileNumber) {
		return gpsTrackingRepository.queryUserGpsTrackingDetails(mobileNumber);
	}

	public List<SimRemovalDto> querySimRemovalDetails(String mobileNumber) {
		List<SimRemovalDetails> querySimRemovalDetails = simRemovalDetailsRepository
				.querySimRemovalDetailsByMobileNumber(mobileNumber);
		List<SimRemovalDto> dtos = new ArrayList<SimRemovalDto>();
		for (SimRemovalDetails details : querySimRemovalDetails) {
			SimRemovalDto simRemovalDto = new SimRemovalDto();
			BeanUtils.copyProperties(details, simRemovalDto, "image");
			if (null != details.getImage()) {
				byte[] encodeBase64;
				try {
					encodeBase64 = details.getImage().getBinaryStream().readAllBytes();
					String base64Encoded = new String(BASE64EncoderStream.encode(encodeBase64), "UTF-8");
					simRemovalDto.setImageStr(base64Encoded);
				} catch (IOException | SQLException e) {
					logger.error("Exception occure while user mobileNumber : {} , error : {}", mobileNumber,
							e.getMessage(), e);
				}
			}
			dtos.add(simRemovalDto);
		}
		return dtos;
	}

	public List<SimRemovalDto> queryEmergencyDetails(String mobileNumber) {
		List<EmeregencyDetails> queryEmergencyDetails = emeregencyDetailsRepository
				.queryEmeregencyDetailsByMobileNumber(mobileNumber);
		List<SimRemovalDto> dtos = new ArrayList<SimRemovalDto>();
		for (EmeregencyDetails details : queryEmergencyDetails) {
			SimRemovalDto simRemovalDto = new SimRemovalDto();
			BeanUtils.copyProperties(details, simRemovalDto, "image");
			if (null != details.getImage()) {
				byte[] encodeBase64;
				try {
					encodeBase64 = details.getImage().getBinaryStream().readAllBytes();
					String base64Encoded = new String(BASE64EncoderStream.encode(encodeBase64), "UTF-8");
					simRemovalDto.setImageStr(base64Encoded);
				} catch (IOException | SQLException e) {
					logger.error("Exception occure while user mobileNumber : {} , error : {}", mobileNumber,
							e.getMessage(), e);
				}
			}
			dtos.add(simRemovalDto);
		}
		return dtos;
	}
}
