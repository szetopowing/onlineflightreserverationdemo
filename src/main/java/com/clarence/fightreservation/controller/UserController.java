package com.clarence.fightreservation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.clarence.fightreservation.entities.User;
import com.clarence.fightreservation.repos.UserRepository;
import com.clarence.fightreservation.services.SecurityService;

@Controller
public class UserController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	SecurityService securityService;

	@RequestMapping("/showReg")
	public String showRegistrationPage() {
		LOGGER.info("Inside showRegistrationPage");
		return "login/registerUser";
	}
	
	@PostMapping("/registerUser")
	public String register(@ModelAttribute("user")  User user) {
		LOGGER.info("Inside register"+user);
		user.setPassword(encoder.encode(user.getPassword()));
		userRepository.save(user);
		return "login/login";
	}

	@RequestMapping("/showLogin")
	public String showLoginPage() {
		LOGGER.info("Inside showLoginPage");
		return "login/login";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam("email") String email, @RequestParam("password") String password, ModelMap modelMap){
		
		LOGGER.info("Inside login = " + email);
		
		boolean loginResponse = securityService.login(email, password);
		
		if (loginResponse) {
			return "findFlights";
		} else {
			modelMap.addAttribute("msg", "Invalid user name or password. Please try again.");
		}
	
		return "login/login";
		
		
	}
}
