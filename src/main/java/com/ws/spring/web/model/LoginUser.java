package com.ws.spring.web.model;

import java.io.Serializable;

public class LoginUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3810272365075403786L;

	private String username;
	private String password;
	private String mobileNumber;
	private long roleId;

	
	public LoginUser() {
		super();
	}

	public LoginUser(String username, String mobileNumber, long roleId) {
		super();
		this.username = username;
		this.mobileNumber = mobileNumber;
		this.roleId = roleId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

}
