package com.ws.spring.web.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ws.common.util.Constants;
import com.ws.common.util.StringUtil;
import com.ws.spring.dto.SimRemovalDto;
import com.ws.spring.dto.UserActivationProcessDto;
import com.ws.spring.dto.UserDto;
import com.ws.spring.model.GpsTrackingDetails;
import com.ws.spring.model.UserDetails;
import com.ws.spring.service.GpsTrackingService;
import com.ws.spring.service.UserService;
import com.ws.spring.web.model.LoginUser;

@Controller
@SessionAttributes("loginUser")
public class LoginController {

	Logger logger = LoggerFactory.getLogger(this.getClass().getName());

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
		logger.info("userLogin action username : {}", username);
		try {
			UserDto userDto = new UserDto();
			userDto.setUsername(username);
			userDto.setPassword(password);
			UserDetails userDetails = userService.userLogin(userDto, Constants.LOGIN_BY_PASSWORD);
			if (null != userDetails) {
				Long roleId = userDetails.getRole().getId();
				logger.info("Login Successfull. username : {} and Role Id : {}", username, roleId);
				modelMap.addAttribute("loginUser", filterUserDetailsFields(userDetails));

				if (Constants.ROLE_ID_SUPERADMIN == roleId || Constants.ROLE_ID_ADMIN == roleId) {
					modelMap.addAttribute("registeredUserList", userService.queryRegisteredUsers());
					modelMap.addAttribute("adminDashboardDetails", userService.getAdminDashboardDetails());
					return "admin";
				}
				if (Constants.ROLE_ID_GENERAL_USER == roleId || Constants.ROLE_ID_REPORTER == roleId) {

					List<GpsTrackingDetails> queryUserGpsTrackingDetails = gpsTrackingService
							.queryUserGpsTrackingDetails(userDetails.getMobileNumber());
					modelMap.addAttribute("usersTrackingDetails", queryUserGpsTrackingDetails);

					List<SimRemovalDto> querySimRemovalDtos = gpsTrackingService
							.querySimRemovalDetails(userDetails.getMobileNumber());
					modelMap.addAttribute("simRemovalDtos", querySimRemovalDtos);

					List<SimRemovalDto> queryEmergencyDetails = gpsTrackingService
							.queryEmergencyDetails(userDetails.getMobileNumber());
					modelMap.addAttribute("emergenceDetails", queryEmergencyDetails);

					return "user";
				}
			} else {
				modelMap.addAttribute("errMsg", "Invalid Credentials, Please try again.");
				logger.warn("Loggin failed due to invalid credentials for the user : {} ", username);
				return "index";
			}

		} catch (Exception e) {
			logger.error("Exception occure while user loginusername : {} , error : {}", username, e.getMessage(), e);
		}

		return "index";
	}

	@RequestMapping(value = "/adminDashboard", method = RequestMethod.GET)
	public String adminDashboard(ModelMap modelMap) {
		try {

			modelMap.addAttribute("registeredUserList", userService.queryRegisteredUsers());
			modelMap.addAttribute("adminDashboardDetails", userService.getAdminDashboardDetails());
			return "admin";

		} catch (Exception e) {
			logger.error("Exception occure while user , error : {}", e.getMessage(), e);
		}

		return "index";
	}

	@RequestMapping(value = "registeredUserList", method = RequestMethod.GET)
	public String registeredUserList(ModelMap modelMap) {
		logger.info("registeredUserList action userName : {}", modelMap);
		modelMap.addAttribute("registeredUserList", userService.queryRegisteredUsers());
		return "userRegistration";
	}

	// Need to verify the query result based on name and mobile number
	// User Records
	@RequestMapping(value = "/queryUserDetailsListByName", method = RequestMethod.GET)
	public String queryUserDetailsList(@RequestParam String userName, @RequestParam("mobileNumber") String mobileNumber,
			ModelMap modelMap) {
		logger.info("queryUserDetailsListByName action");
		if (!(StringUtil.checkNullOrEmpty(userName) || StringUtil.checkNullOrEmpty(mobileNumber))) {
			List<UserDetails> queryUserDetailsByUserNameOrMobile = userService
					.queryUserDetailsByUserNameOrMobile(userName, mobileNumber);
			modelMap.addAttribute("userDetailsList", queryUserDetailsByUserNameOrMobile);
		} else {
			List<UserDetails> queryAllUserList = userService.queryAllUserList();
			modelMap.addAttribute("userDetailsList", queryAllUserList);
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
	public String approveUser(@RequestParam("userIds") Long[] userIds,
			@RequestParam("operationType") String operationType, @RequestParam("reason") String reason,
			ModelMap modelMap) {
		logger.info("userActivationProcess action");
		UserActivationProcessDto activationProcessDto = new UserActivationProcessDto(userIds, operationType, reason);
		try {
			userService.userActivationProcess(activationProcessDto);
			modelMap.addAttribute("msg", operationType + " activity is succeffully submited");
			modelMap.addAttribute("registeredUserList", userService.queryRegisteredUsers());
		} catch (Exception e) {
			logger.error("Exception occure while user activation process userIds:{}, operationType:{}, reason:{} ",
					userIds, operationType, reason, e.getMessage(), e);
			modelMap.addAttribute("errmsg", operationType + "is failled");
		}
		return "userRegistration";
	}

	/**
	 * This method used to get the user GPS tracking
	 * 
	 * @param mobileNumber
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/queryUsersTrackingDetails", method = RequestMethod.GET)
	public ModelMap queryUsersTrackingDetails(@RequestParam("mobileNumber") String mobileNumber, ModelMap modelMap) {
		logger.info("queryUsersTrackingDetails action");
		List<GpsTrackingDetails> queryUserGpsTrackingDetails = gpsTrackingService
				.queryUserGpsTrackingDetails(mobileNumber);
		modelMap.addAttribute("usersTrackingDetails", queryUserGpsTrackingDetails);
		return modelMap;
	}

	@RequestMapping(value = "/userLogout", method = RequestMethod.GET)
	public String userLogout(@RequestParam("userName") String userName, ModelMap modelMap) {
		modelMap.remove("loginUser");
		return "index";
	}

	private LoginUser filterUserDetailsFields(UserDetails userDetails) {
		return new LoginUser(userDetails.getUserName(), userDetails.getMobileNumber(), userDetails.getRole().getId());
	}
}
