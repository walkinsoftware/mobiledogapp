package com.ws.common.util;

public interface Constants {

	/**
	 * TIme zone used for the application
	 */
	String TIME_ZONE_ID = "Asia/Kolkata";
	/**
	 * User Role description
	 */
	long ROLE_ID_SUPERADMIN = 1;
	long ROLE_ID_GENERAL_USER = 2;
	long ROLE_ID_ADMIN = 3;
	long ROLE_ID_REPORTER = 4;

	/**
	 * isActive parameter descriptions
	 */
	int REGISTERED = 0;
	int ACTIVE = 1;
	int REJECTED = 2;
	int BLOCKED = 3;

	/** The Constant BLANK. */
	String EMPTY_STR = "";

	/** The Constant COLON. */
	String COLON = " : ";

	/** The Constant DASH. */
	String DASH = " - ";

	/** The Constant KEY_TXNID. */
	String KEY_TXNID = "TXNID";

	/** The Constant XPATH_TXNID. */
	String XPATH_TXNID = "//transcationId";

	/** The Constant ENTRY. */
	String ENTRY = "Entry";

	/** The Constant EXIT. */
	String EXIT = "Exit";

	/** COnstant int numbers */
	int INT_SIX = 6;

	String REGISTRATION_STR = "REGISTRATION";

	String LOGIN_BY_MPIN = "LOGIN_BY_MPIN";

	String LOGIN_BY_OTP = "LOGIN_BY_OTP";

	String LOGIN_BY_PASSWORD = "LOGIN_BY_PASSWORD";
	
	/**
	 * sms message code and content
	 */
	String SMS_EMERENCY = "mdogapp.sms.emeregency";
	
	long ONE_SECOND = 1000;
	
	long ONE_MIN = 60 * ONE_SECOND;
	
	long ONE_HOUR = 60 * ONE_MIN;
	
}
