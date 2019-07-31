package com.ws.spring.web.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ws.common.util.Constants;
import com.ws.common.util.StringUtil;
import com.ws.spring.dto.UserActivationProcessDto;
import com.ws.spring.dto.UserDto;
import com.ws.spring.model.UserDetails;
import com.ws.spring.service.GpsTrackingService;
import com.ws.spring.service.UserService;
import com.ws.spring.web.model.LoginUser;

@Controller
@SessionAttributes("loginUser")
public class LoginController {

	Logger logger = LogManager.getLogger(this.getClass().getName());

	@Autowired
	UserService userService;

	@Autowired
	GpsTrackingService gpsTrackingService;

	/*
	 * @GetMapping("/") public String index(HttpSession httpSession) {
	 * logger.info("Loading the index page"); return "index"; }
	 */

	@RequestMapping(value = "/userLogin", method = RequestMethod.POST)
	public String userLogin(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("uname") String username, @RequestParam("pwd") String password, ModelMap modelMap) {
		logger.info("userLogin action");
		try {
			UserDto userDto = new UserDto();
			userDto.setUsername(username);
			userDto.setPassword(password);
			UserDetails userDetails = userService.userLogin(userDto, Constants.LOGIN_BY_PASSWORD);
			if (null != userDetails) {
				modelMap.addAttribute("loginUser", filterUserDetailsFields(userDetails));

				if (Constants.ROLE_ID_SUPERADMIN == userDetails.getRole().getId()
						|| Constants.ROLE_ID_ADMIN == userDetails.getRole().getId()) {
					modelMap.addAttribute("registeredUserList", userService.queryRegisteredUsers());
					modelMap.addAttribute("adminDashboardDetails", userService.getAdminDashboardDetails());
					return "Admin";
				}
				if (Constants.ROLE_ID_SUPER_USER == userDetails.getRole().getId()
						|| Constants.ROLE_ID_GENERAL_USER == userDetails.getRole().getId()) {
					return "user";
				}
			} else {
				modelMap.addAttribute("errMsg", "Invalid Credentials, Please try again.");
				logger.warn("Loggin failed due to invalid credentials for the user : {} ", username);
				return "index";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "index";
	}

	@RequestMapping(value = "registeredUserList", method = RequestMethod.GET)
	public String registeredUserList(ModelMap modelMap) {
		logger.info("registeredUserList action");
		modelMap.addAttribute("registeredUserList", userService.queryRegisteredUsers());
		return "userRegistration";
	}

	// Need to verify the query result based on name and mobile number
	// User Records
	@RequestMapping(value = "/queryUserDetailsListByName", method = RequestMethod.GET)
	public String queryUserDetailsList(@RequestParam String userName, @RequestParam String mobileNumber,
			ModelMap modelMap) {
		logger.info("queryUserDetailsListByName action");
		if (!(StringUtil.checkNullOrEmpty(userName) || StringUtil.checkNullOrEmpty(mobileNumber))) {
			modelMap.addAttribute("userDetailsList",
					userService.queryUserDetailsByUserNameOrMobile(userName, mobileNumber));
		} else {
			modelMap.addAttribute("userDetailsList", userService.queryAllUserList());
		}
		return "userReport";
	}

	// Need to verify the query result
	@RequestMapping(value = "/queryUsersListByDates", method = RequestMethod.POST)
	public String queryUsersList(@RequestParam("status") String status, @RequestParam("fromDate") Date fromDate,
			@RequestParam("toDate") Date toDate, ModelMap modelMap) {
		logger.info("queryUsersListByDates action");
		modelMap.addAttribute("userDetailsList", userService.queryUsersListByDates(status, fromDate, toDate));
		return "userReport";
	}

	/**
	 * 
	 * @param userIds
	 * @param operationType APPROVE or REJECT
	 * @param reason
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/userActivationProcess", method = RequestMethod.POST)
	public String approveUser(@RequestParam("ids") Long[] userIds, @RequestParam("operationType") String operationType,
			@RequestParam("reason") String reason, ModelMap modelMap) {
		logger.info("userActivationProcess action");
		UserActivationProcessDto activationProcessDto = new UserActivationProcessDto(userIds, operationType, reason);
		try {
			userService.userActivationProcess(activationProcessDto);
			modelMap.addAttribute("msg", operationType + "is succeffully submited");
		} catch (Exception e) {
			logger.error("Exception occure while user activation process userIds:{}, operationType:{}, reason:{} ",
					userIds, operationType, reason, e.getMessage());
			modelMap.addAttribute("errmsg", operationType + "is failled");
		}
		return "Admin";
	}

	/**
	 * This method used to get the user GPS tracking
	 * 
	 * @param mobileNumber
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/queryUsersTrackingDetails", method = RequestMethod.POST)
	public ModelMap queryUsersTrackingDetails(@RequestParam("mobileNumber") String mobileNumber, ModelMap modelMap) {
		logger.info("queryUsersTrackingDetails action");
		modelMap.addAttribute("usersTrackingDetails", gpsTrackingService.queryUserGpsTrackingDetails(mobileNumber));
		return modelMap;
	}

	private LoginUser filterUserDetailsFields(UserDetails userDetails) {
		return new LoginUser(userDetails.getUserName(), userDetails.getMobileNumber(), userDetails.getRole().getId());
	}
}
