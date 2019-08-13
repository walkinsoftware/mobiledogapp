package com.ws.spring.rest.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import com.ws.common.util.ClientResponseUtil;
import com.ws.spring.dto.SimRemovalDto;
import com.ws.spring.exception.ClientResponseBean;
import com.ws.spring.model.EmeregencyDetails;
import com.ws.spring.model.GpsTrackingDetails;
import com.ws.spring.model.SimRemovalDetails;
import com.ws.spring.service.EmeregencyDetailsService;
import com.ws.spring.service.GpsTrackingService;
import com.ws.spring.service.SimRemovalDetailsService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = "/gpstracking")
@Api(value = "GPS Management System", tags = "Operations pertaining to gps in Global Position System")
public class GlobalPositionController {

	Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	SimRemovalDetailsService simRemovalDetailsService;

	@Autowired
	EmeregencyDetailsService emeregencyDetailsService;

	@Autowired
	GpsTrackingService gpsTrackingService;

	@PostMapping("/v1/simremoval")
	public ClientResponseBean simRemoval(@ModelAttribute SimRemovalDto simRemovalDto) {
		try {
			String mobileNumber = simRemovalDto.getMobileNumber();
			logger.info("simRemoval simRemovalDto details : {}", simRemovalDto);
			SimRemovalDetails simRemovalDetails = new SimRemovalDetails();
			BeanUtils.copyProperties(simRemovalDto, simRemovalDetails, "image");
			MultipartFile image = simRemovalDto.getImage();
			if (!image.isEmpty()) {
				try {
					byte[] bytes = image.getBytes();
					simRemovalDetails.setImage(new SerialBlob(bytes));
				} catch (IOException | SQLException e) {
					logger.error("Exception occured while simremoval, mobileNumber : {}", mobileNumber, e);
				}
			}
			if (null != simRemovalDetailsService.insert(simRemovalDetails))
				return ClientResponseUtil.getSuccessResponse();

			logger.warn("addimg sim removal data failed");
			return ClientResponseUtil.getErrorResponse();
		} catch (Exception ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User Registration got an Error", ex);
		}
	}

	@GetMapping("/v1/querySimRemovalDetails")
	public List<SimRemovalDetails> querySimRemovalDetails(@RequestParam String mobileNumber) {
		try {
			return simRemovalDetailsService.querySimRemovalDetailsByMobileNumber(mobileNumber);
		} catch (Exception ex) {
			logger.error("Exception Occure : {} ", ex.getMessage(), ex);
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User Registration got an Error", ex);
		}
	}

	@PostMapping("/v1/addUserGpsTrackingDetails")
	public ClientResponseBean addUserGpsTrackingDetails(@RequestBody GpsTrackingDetails userGpsTrackingDetails) {
		gpsTrackingService.addUserGpsTrackingDetails(userGpsTrackingDetails);
		return null;
	}

	@GetMapping("/v1/queryUserGpsTrackingDetails")
	public List<GpsTrackingDetails> queryUserGpsTrackingDetails(@RequestParam String mobileNumber) {
		try {
			return gpsTrackingService.queryUserGpsTrackingDetails(mobileNumber);
		} catch (Exception ex) {
			logger.error("Exception Occure : {} ", ex.getMessage(), ex);
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User Registration got an Error", ex);
		}
	}

	@PostMapping("/v1/emergency")
	public ClientResponseBean emeregency(@ModelAttribute SimRemovalDto simRemovalDto) {
		try {
			String mobileNumber = simRemovalDto.getMobileNumber();
			logger.info("simRemoval simRemovalDto details : {}", simRemovalDto);
			EmeregencyDetails emeregencyDetails = new EmeregencyDetails();
			BeanUtils.copyProperties(simRemovalDto, emeregencyDetails, "image");
			MultipartFile image = simRemovalDto.getImage();
			if (null != image && !image.isEmpty()) {
				try {
					byte[] bytes = image.getBytes();
					emeregencyDetails.setImage(new SerialBlob(bytes));
				} catch (IOException | SQLException e) {
					logger.error("Exception occured while simremoval, mobileNumber : {}", mobileNumber, e);
				}
			}
			EmeregencyDetails emerenecy = emeregencyDetailsService.insert(emeregencyDetails);
			if (null != emerenecy) {
				// Send SMS to Secondary mobile number
				return ClientResponseUtil.getSuccessResponse();
			}
			logger.warn("addimg sim removal data failed");
			return ClientResponseUtil.getErrorResponse();
		} catch (Exception ex) {
			logger.error("Exception Occure : {} ", ex.getMessage(), ex);
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User Registration got an Error", ex);
		}
	}
}
