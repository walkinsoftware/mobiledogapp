package com.ws.spring.web.controller;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.ws.common.util.Constants;
import com.ws.common.util.StringUtil;
import com.ws.spring.dto.UserActivationProcessDto;
import com.ws.spring.dto.UserDto;
import com.ws.spring.model.UserDetails;
import com.ws.spring.service.UserService;
import com.ws.spring.web.model.LoginUser;

@Controller
@SessionAttributes("loginUser")
public class LoginController {

	Logger logger = LogManager.getLogger(this.getClass().getName());

	@Autowired
	UserService userService;

	@GetMapping("/")
	public String index(HttpSession httpSession) {
		logger.info("Loading the index page");
		return "index";
	}

	@PostMapping(value = "/userLogin")
	public String userLogin(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("uname") String username, @RequestParam("psw") String password, ModelMap modelMap) {
		try {
			UserDto userDto = new UserDto();
			userDto.setUsername(username);
			userDto.setPassword(password);
			UserDetails userDetails = userService.userLogin(userDto, Constants.LOGIN_BY_PASSWORD);
			if (null != userDetails) {

				modelMap.addAttribute("loginUser", filterUserDetailsFields(userDetails));
				modelMap.addAttribute("registeredUserList", userService.queryInactiveUsers());
				return "admin";
				/*
				 * if (Constants.ROLE_ID_ADMIN == userDetails.getRole().getId()) { return
				 * "admin"; } if (Constants.ROLE_ID_GENERAL_USER ==
				 * userDetails.getRole().getId()) { return "user"; }
				 */
			} else {
				logger.warn("Loggin failed due to invalid credentials for the user : {} ", username);
				modelMap.addAttribute("errorMessage", "Invalid credentials!!");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "index";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView executeLogin(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("uname") String username, @RequestParam("psw") String password) {
		ModelAndView model = null;
		try {
			UserDto userDto = new UserDto();
			userDto.setUsername(username);
			userDto.setPassword(password);
			UserDetails userDetails = userService.userLogin(userDto, Constants.LOGIN_BY_PASSWORD);
			if (null != userDetails) {
				request.setAttribute("loggedInUser", username);
				if (Constants.ROLE_ID_ADMIN == userDetails.getRole().getId()) {
					model = new ModelAndView("admin", "output", "User Login success full");
				}
				if (Constants.ROLE_ID_GENERAL_USER == userDetails.getRole().getId()) {
					model = new ModelAndView("user", "output", "User Login success full");
				}
				model.addObject("userDto", userDto);
			} else {
				logger.warn("Loggin failed due to invalid credentials for the user : {} ", username);
				request.setAttribute("errorMessage", "Invalid credentials!!");
				model = new ModelAndView("error", "output", "out put Invalid credentials!");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return model;
	}

	@RequestMapping(value = "/queryUserDetailsList", method = RequestMethod.GET)
	public ModelAndView queryUserDetailsList(@RequestParam String userName, @RequestParam String mobileNumber) {
		ModelAndView mav = new ModelAndView("userdetailslist");
		if (!(StringUtil.checkNullOrEmpty(userName) || StringUtil.checkNullOrEmpty(mobileNumber))) {
			mav.addObject("userDetailsList", userService.queryUserDetailsByUserNameOrMobile(userName, mobileNumber));
		} else {
			mav.addObject("userDetailsList", userService.queryAllUserList());
		}
		return mav;
	}

	/**
	 * 
	 * @param userIds
	 * @param operationType APPROVE or REJECT
	 * @param reason
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/userActivationProcess", method = RequestMethod.GET)
	public ModelMap approveUser(@RequestParam("ids") Long[] userIds,
			@RequestParam("operationType") String operationType, @RequestParam("reason") String reason,
			ModelMap modelMap) {
		UserActivationProcessDto activationProcessDto = new UserActivationProcessDto(userIds, operationType, reason);
		userService.userActivationProcess(activationProcessDto);
		return modelMap;
	}

	private LoginUser filterUserDetailsFields(UserDetails userDetails) {
		return new LoginUser(userDetails.getUserName(), userDetails.getMobileNumber(), userDetails.getRole().getId());
	}
}
