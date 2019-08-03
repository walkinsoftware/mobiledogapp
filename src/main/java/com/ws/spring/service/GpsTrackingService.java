package com.ws.spring.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

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

			byte[] encodeBase64;
			try {
				encodeBase64 = details.getImage().getBinaryStream().readAllBytes();
				String base64Encoded = new String(BASE64EncoderStream.encode(encodeBase64), "UTF-8");
				simRemovalDto.setImageStr(base64Encoded);
			} catch (IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dtos.add(simRemovalDto);
		}
		return dtos;
	}

	public List<EmeregencyDetails> queryEmergencyDetails(String mobileNumber) {
		return emeregencyDetailsRepository.queryEmeregencyDetailsByMobileNumber(mobileNumber);
	}
}
