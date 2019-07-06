package com.ws.spring.exception;

public class ClientResponseBean {

	private int responseCode;
	private String status;
	private String message;
	private Object data;
	private String errorMessage;
	private Exception exception;

	public ClientResponseBean(int responseCode, String status, String message, String errorMessage) {
		super();
		this.responseCode = responseCode;
		this.status = status;
		this.message = message;
		this.errorMessage = errorMessage;
	}

	public ClientResponseBean(ResponseCodes responseCodes) {
		super();
		this.responseCode = responseCodes.getResponseCode();
		this.status = responseCodes.getStatus();
		this.message = responseCodes.getMessage();
		this.errorMessage = responseCodes.getErrorMessage();
	}

	public ClientResponseBean(int responseCode, String status, String message, Object data, String errorMessage) {
		super();
		this.responseCode = responseCode;
		this.status = status;
		this.message = message;
		this.data = data;
		this.errorMessage = errorMessage;
	}

	public ClientResponseBean(int responseCode, String status, String message, String errorMessage, String descption,
			Exception exeption) {
		super();
		this.responseCode = responseCode;
		this.status = status;
		this.message = message;
		this.errorMessage = errorMessage;
		this.exception = exeption;

	}

	public int getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public Exception getException() {
		return exception;
	}

	public void setException(Exception exception) {
		this.exception = exception;
	}
}
