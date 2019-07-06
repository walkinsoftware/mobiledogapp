package com.ws.spring.exception;

import org.springframework.http.HttpStatus;

public enum ResponseCodes {

	USER_BARCODE_EXIST(1003, "FAILED", "", "Bar Code already Registered"),
	USER_REGISTRATION(HttpStatus.CREATED.value(), "SUUCESS", "User Registration Completed.","");

	private final int responseCode;
	private final String status;
	private final String message;
	private final String errorMessage;

	private ResponseCodes(int responseCode, String status, String message, String errorMessage) {
		this.responseCode = responseCode;
		this.status = status;
		this.message = message;
		this.errorMessage = errorMessage;
	}

	public int getResponseCode() {
		return responseCode;
	}

	public String getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
}
