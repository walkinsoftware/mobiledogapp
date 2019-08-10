package com.ws.spring.rest.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ws.common.util.ClientResponseUtil;
import com.ws.common.util.Constants;
import com.ws.common.util.StringUtil;
import com.ws.spring.dto.UserActivationProcessDto;
import com.ws.spring.dto.UserDto;
import com.ws.spring.dto.UserOtpBean;
import com.ws.spring.exception.ClientResponseBean;
import com.ws.spring.exception.UserDetailNotFoundException;
import com.ws.spring.model.UserDetails;
import com.ws.spring.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

//@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/home")
@Api(value = "User Management System", tags = "Operations pertaining to user in User Management System")
public class HomeRestController {

	@Autowired
	UserService userService;

	Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	@GetMapping("/v1/index")
	public String index() {
		logger.info("Loading index page");
		return "index";
	}

	@GetMapping("/v1/testing")
	public String testing() {
		logger.info("App testing {}", new Date());
		return "App is up and running";
	}
	
	@GetMapping("/v1/getTimeByTimeZone")
	public Map<String, String> getTimeByTimeZone(@RequestParam String timezoneId) {
		Date currentDateTime = new Date();
		logger.info("App testing {}", currentDateTime);
		TimeZone timeZone = TimeZone.getTimeZone(timezoneId);
		TimeZone.setDefault(timeZone);
		Calendar calendarInstance = Calendar.getInstance();
		calendarInstance.setTimeZone(timeZone);
		Map<String, String> times = new HashMap<String, String>();
		times.put("Date ", currentDateTime.toString());
		times.put("Calendar ", calendarInstance.getTime().toString());
		
		return times;
	}

	/**
	 * userRegistration this method will register user into system
	 * 
	 * @param user
	 * @return
	 */
	@ApiOperation(value = "User Registration", response = ClientResponseBean.class)
	@ApiResponses(value = { @ApiResponse(code = 201, message = "User Registration successful"),
			@ApiResponse(code = 1001, message = "User Opt validation failed."),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	@PostMapping("/v1/userRegistration")
	@ResponseStatus(HttpStatus.CREATED)
	public ClientResponseBean userRegistration(
			@ApiParam(value = "UserDetail store in database table", required = true) @Valid @RequestBody UserDetails user) {
		logger.info("userRegistration for UserName : {}", user.getUserName());
		try {
			return userService.userRegistration(user);

		} catch (Exception ex) {
			logger.error("Exception Occure : {} ", ex.getMessage(), ex);
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "User Registration got an Error", ex);
		}
	}

	/**
	 * Verify hash code and is it matches then based on the is_active field send
	 * response to user if IS_Active is 0 then send user registration is completed
	 * if IS_ACTIVE is 1 then send reset password page to user
	 * 
	 * @return
	 */
	@GetMapping(value = "/v1/verifyHashCode")
	public ClientResponseBean verifyHashCode(@RequestParam("userName") String userName,
			@RequestParam("hashCode") String hashCode) {
		logger.info("verifyHashCode for UserName : {}", userName);
		try {
			// hashCode = StringUtil.decode(hashCode);
			UserDetails userDetails = userService.verifyHashCode(userName, hashCode);
			if (null != userDetails) {
				return ClientResponseUtil.getUserOptValidationSuccess();
			}
			return ClientResponseUtil.getUserOptValidationFailed();
		} catch (Exception ex) {
			logger.error("Exception Occure : {} ", ex.getMessage(), ex);
			throw new ResponseStatusException(HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS, "Exception Occured", ex);
		}
	}

	@ApiOperation(value = "Generate Otp for validation", response = ClientResponseBean.class)
	@PostMapping("/v1/generateOtp")
	public ClientResponseBean generateOtp(@RequestBody UserOtpBean userOptBean) {
		try {
			String userName = userOptBean.getMobileNumber();
			if (StringUtil.checkNullOrEmpty(userName)) {
				userName = userOptBean.getUserName();
			}
			logger.info("generate Otp for userName : {}", userName);
			UserOtpBean userOptBeanReturn = null;
			if (!StringUtil.checkNullOrEmpty(userOptBean.getActivity())
					&& Constants.REGISTRATION_STR.equals(userOptBean.getActivity())) {
				userOptBeanReturn = userService.generateOpt(userOptBean);
			} else {
				userOptBeanReturn = userService.sendOtp(userOptBean);
			}
			if (null != userOptBeanReturn) {
				return ClientResponseUtil.sentOptSucces();
			}
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User Not FOund",
					new UserDetailNotFoundException("User Not Found"));
		} catch (Exception ex) {
			logger.error("Exception Occure : {} ", ex.getMessage(), ex);
			throw new ResponseStatusException(HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS, "Exception Occured", ex);
		}
	}

	@GetMapping("/v1/verifyUserOtp")
	public ClientResponseBean verifyUserOtp(@RequestBody UserDto userDto) {
		logger.info("verifyUserOtp Otp for userName : {} and opt : {}", userDto.getUsername(), userDto.getOtp());
		try {
			UserOtpBean userOptBean = userService.verifyUserOtp(userDto.getUsername(), userDto.getOtp());
			if (null != userOptBean) {
				return ClientResponseUtil.getUserOptValidationSuccess();
			}
			return ClientResponseUtil.getUserOptValidationFailed();
		} catch (Exception ex) {
			logger.error("Exception Occure : {} ", ex.getMessage(), ex);
			throw new ResponseStatusException(HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS, "Exception Occured", ex);
		}
	}

	@PostMapping("/v1/setUserMpin")
	public ClientResponseBean setUserMpin(@RequestBody UserDto userDto) {
		String username = userDto.getUsername();
		logger.info("setUserMpin for user name : {}", username);
		try {
			userService.setUserMpin(username, userDto.getMpin());
			return ClientResponseUtil.getSuccessResponse();
		} catch (Exception ex) {
			logger.error("Exception Occure : {} ", ex.getMessage(), ex);
			throw new ResponseStatusException(HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS, "Exception Occured", ex);
		}
	}

	@PostMapping("/v1/forgotPassword")
	public ResponseEntity<ClientResponseBean> forgotPassword(@RequestBody UserDto userDto) {
		String username = userDto.getUsername();
		logger.info("forgotPassword for username : {}", username);
		try {
			if (userService.forgotPassword(username)) {
				return new ResponseEntity<>(ClientResponseUtil.sentOptSucces(), HttpStatus.OK);
			}
			logger.warn("forgotPassword : User Details not found for username : {}", username);
			return new ResponseEntity<>(ClientResponseUtil.getUserDetailNotFoundResponse(username),
					HttpStatus.NOT_FOUND);
		} catch (Exception ex) {
			logger.error("Exception Occure : {} ", ex.getMessage(), ex);
			throw new ResponseStatusException(HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS, "Exception Occured", ex);
		}
	}

	@PostMapping("/v1/resetPassword")
	public ClientResponseBean resetPassword(@RequestBody UserDto userDto) {
		logger.info("resetPassword for user : {}", userDto.getUsername());
		try {
			if (userService.resetPassword(userDto)) {
				return ClientResponseUtil.getSuccessResponse();
			}
			return ClientResponseUtil.getErrorResponse();
		} catch (Exception ex) {
			logger.error("Exception Occure : {} ", ex.getMessage(), ex);
			throw new ResponseStatusException(HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS, "Exception Occured", ex);
		}
	}

	@PostMapping("/v1/changePassword")
	public ClientResponseBean changePassword(@RequestBody UserDto userDto) {
		logger.info("changePassword for user : {}", userDto.getUsername());
		try {
			if (userService.changePassword(userDto)) {
				return ClientResponseUtil.getSuccessResponse();
			}
			return ClientResponseUtil.getErrorResponse();
		} catch (Exception ex) {
			logger.error("Exception Occure : {} ", ex.getMessage(), ex);
			throw new ResponseStatusException(HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS, "Exception Occured", ex);
		}
	}

	// Login with fingerprint option need to implement
	@PostMapping("/v1/userLoginByPassword")
	public ClientResponseBean userLoginByPassword(@RequestBody UserDto userDto) {
		logger.info("userLoginByPassword for user : {}", userDto.getUsername());
		try {
			logger.info("User login process : {}", userDto);
			UserDetails userDetails = userService.userLogin(userDto, Constants.LOGIN_BY_PASSWORD);
			if (null != userDetails) {
				logger.info("User login process success : {}", userDto.getUsername());
				return ClientResponseUtil.userLoginSuccess();
			}
			logger.info("User login process failed : {}", userDto.getUsername());
			return ClientResponseUtil.userLoginFailed();
		} catch (Exception ex) {
			logger.error("Exception Occure : {} ", ex.getMessage(), ex);
			throw new ResponseStatusException(HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS, "Exception Occured", ex);
		}
	}

	@PostMapping("/v1/userLoginByOtp")
	public ClientResponseBean userLoginByOtp(@RequestBody UserDto userDto) {
		logger.info("userLoginByOtp for user : {}", userDto.getUsername());
		try {
			logger.info("User login process : {}", userDto);
			UserDetails userDetails = userService.userLogin(userDto, Constants.LOGIN_BY_OTP);
			if (null != userDetails) {
				logger.info("User login process success : {}", userDto.getUsername());
				return ClientResponseUtil.userLoginSuccess();
			}
			logger.info("User login process failed : {}", userDto.getUsername());
			return ClientResponseUtil.userLoginFailed();
		} catch (Exception ex) {
			logger.error("Exception Occure : {} ", ex.getMessage(), ex);
			throw new ResponseStatusException(HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS, "Exception Occured", ex);
		}
	}

	@PostMapping("/v1/userLoginByMpin")
	@ApiOperation(value = "User Login using Pin", response = ClientResponseBean.class)
	@ApiParam(required = true, value = "username")
	@ApiResponses(value = { @ApiResponse(code = 1000, message = "User Login success."),
			@ApiResponse(code = 1001, message = "User Login Failed."),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public ClientResponseBean userLoginByMpin(@RequestBody UserDto userDto) {
		logger.info("userLoginMpin for user : {}", userDto.getUsername());
		try {
			logger.info("User MPIN login process : {}", userDto);
			UserDetails userDetails = userService.userLogin(userDto, Constants.LOGIN_BY_MPIN);
			if (null != userDetails) {
				logger.info("User login process success : {}", userDto.getUsername());
				return ClientResponseUtil.userLoginSuccess();
			}
			logger.warn("User login process failed : {}", userDto.getUsername());
			return ClientResponseUtil.userLoginFailed();
		} catch (Exception ex) {
			logger.error("Exception Occure : {} ", ex.getMessage(), ex);
			throw new ResponseStatusException(HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS, "Exception Occured", ex);
		}
	}

	@GetMapping("/v1/queryInactiveUsers")
	public List<UserDetails> queryInactiveUsers() {
		logger.info("queryInactiveUsers ");
		try {
			return userService.queryRegisteredUsers();
		} catch (Exception ex) {
			throw new ResponseStatusException(HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS, "Exception Occured", ex);
		}
	}

	@ApiOperation(value = "User activation process ")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "ok"),
			@ApiResponse(code = 403, message = "An unexpected error occurred") })
	@PostMapping("/v1/userActivationProcess")
	public ClientResponseBean userActivationProcess(@RequestBody UserActivationProcessDto activationProcessDto) {
		logger.info("userActivationProcess ");
		try {
			userService.userActivationProcess(activationProcessDto);
			return ClientResponseUtil.getSuccessResponse();
		} catch (Exception ex) {
			throw new ResponseStatusException(HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS, "Exception Occured ", ex);
		}
	}

	@ApiOperation(value = "Query User Profile", response = UserDetails.class)
	@ApiResponses(value = { @ApiResponse(code = 500, message = "Internal Server Error") })
	@GetMapping("/v1/getUserProfile")
	public UserDetails getUserProfile(@RequestParam("userName") String userName) {

		UserDetails userDetails = userService.queryLoginUserDetails(userName);

		return userDetails;
	}

	@ApiOperation(value = "Update User Profile", response = ClientResponseBean.class)
	@ApiResponses(value = { @ApiResponse(code = 1000, message = "User profile updated"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	@PostMapping("/v1/updateUserProfile")
	public ClientResponseBean updateUserProfile(@RequestBody UserDetails userDetails) {
		return ClientResponseUtil.getSuccessResponse();
	}
}
