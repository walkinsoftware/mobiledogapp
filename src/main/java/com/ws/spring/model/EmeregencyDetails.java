package com.ws.spring.model;

import java.io.Serializable;
import java.sql.Blob;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "t_ws_emeregency_details")
public class EmeregencyDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8815811066375046638L;

	@Id
	@GeneratedValue
	private Long id;

	private String mobileNumber;

	private String imeiNum;

	private String longitude;

	private String lattitude;

	@CreationTimestamp
	private LocalDate insertedDate;

	private Blob image;

	public EmeregencyDetails() {
		super();
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

	public LocalDate getInsertedDate() {
		return insertedDate;
	}

	public void setInsertedDate(LocalDate insertedDate) {
		this.insertedDate = insertedDate;
	}

	public Blob getImage() {
		return image;
	}

	public void setImage(Blob image) {
		this.image = image;
	}
}
