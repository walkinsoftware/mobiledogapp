package com.ws.spring.dto;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

public class SimRemovalDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 375003528659244453L;

	private String mobileNumber;

	private String imeiNum;

	private String longitude;

	private String lattitude;

	private MultipartFile image;
	
	private String imageStr;
	


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
}
