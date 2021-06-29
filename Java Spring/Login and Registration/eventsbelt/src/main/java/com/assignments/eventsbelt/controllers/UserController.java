package com.assignments.eventsbelt.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.assignments.eventsbelt.models.User;
import com.assignments.eventsbelt.services.UserService;
import com.assignments.eventsbelt.validator.UserValidator;

@Controller
public class UserController {

	private final UserService userService;
	private final UserValidator userValidator;

	public UserController(UserService userService, UserValidator userValidator) {
		this.userService = userService;
		this.userValidator = userValidator;
	}

	@RequestMapping("/")
	public String homePage(@ModelAttribute("user") User user, HttpSession session) {
		if (session.getAttribute("userId") != null) {
			return "redirect:/welcome";
		}
		return "home.jsp";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		userValidator.validate(user, result);
		if (result.hasErrors()) {
			return "home.jsp";
		}
		User newuser = userService.registerUser(user);
		session.setAttribute("userId", newuser.getId());
		return "redirect:/welcome";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginUser(@ModelAttribute("user") User user, @RequestParam("email") String email,
			@RequestParam("password") String password, Model model, HttpSession session) {
		if (userService.authenticateUser(email, password)) {
			User newuser = userService.findByEmail(email);
			session.setAttribute("userId", newuser.getId());
			return "redirect:/welcome";
		} else {
			model.addAttribute("logerror", "Invalid Credentials. Please try again.");
			return "home.jsp";
		}

	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

}