package com.ws.spring.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class SimRemovalDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 375003528659244453L;
	
	private long id;

	private String mobileNumber;

	private String imeiNum;

	private String longitude;

	private String lattitude;

	private MultipartFile image;
	
	private String imageStr;
	
	private LocalDateTime insertedDate;

}
