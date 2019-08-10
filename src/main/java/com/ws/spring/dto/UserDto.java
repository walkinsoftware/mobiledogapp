package com.ws.spring.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class UserDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4618329720480093775L;

	private String username;
	
	private String mobileNumber;
	
	private String emailId;
	
	private String imeiNumber;

	private String isOptVerified;

	private String password;

	private String currentPassword;

	private String newPassword;

	private String otp;

	private String mpin;
	
}
