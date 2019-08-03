package com.ws.spring.dto;

import java.io.Serializable;
import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class SimRemovalDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 375003528659244453L;

	private Long id;

	private String mobileNumber;

	private String imeiNum;

	private String longitude;

	private String lattitude;

	private MultipartFile image;
	
	private String imageStr;
	
	private Date insertedDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getImeiNum() {
		return imeiNum;
	}

	public void setImeiNum(String imeiNum) {
		this.imeiNum = imeiNum;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLattitude() {
		return lattitude;
	}

	public void setLattitude(String lattitude) {
		this.lattitude = lattitude;
	}

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}

	public String getImageStr() {
		return imageStr;
	}

	public void setImageStr(String imageStr) {
		this.imageStr = imageStr;
	}

	public Date getInsertedDate() {
		return insertedDate;
	}

	public void setInsertedDate(Date insertedDate) {
		this.insertedDate = insertedDate;
	}
	
	
}
