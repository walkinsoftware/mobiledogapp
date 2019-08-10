package com.ws.spring.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "t_ws_user_gps_details")
public class GpsTrackingDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5157069085793687027L;

	@Id
	@GeneratedValue
	private Long id;

	private String mobileNumber;

	private String imeiNum;

	private String longitude;

	private String lattitude;

	@CreationTimestamp
	private LocalDateTime insertedTime;

	public GpsTrackingDetails() {
		super();
	}

	public GpsTrackingDetails(Long id, String mobileNumber, String imeiNum, String langitude, String lattitude,
			LocalDateTime insertedTime) {
		super();
		this.id = id;
		this.mobileNumber = mobileNumber;
		this.imeiNum = imeiNum;
		this.longitude = langitude;
		this.lattitude = lattitude;
		this.insertedTime = insertedTime;
	}

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

	public LocalDateTime getInsertedTime() {
		return insertedTime;
	}

	public void setInsertedTime(LocalDateTime insertedTime) {
		this.insertedTime = insertedTime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return String.format(
				"UserGpsTrackingDetails [id=%s, mobileNumber=%s, imeiNum=%s, langitude=%s, lattitude=%s, insertedTime=%s]",
				id, mobileNumber, imeiNum, longitude, lattitude, insertedTime);
	}

}
