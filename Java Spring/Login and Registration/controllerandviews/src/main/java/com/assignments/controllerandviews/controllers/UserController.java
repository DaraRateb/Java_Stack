package com.assignments.controllerandviews.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.assignments.controllerandviews.models.User;
import com.assignments.controllerandviews.services.UserService;

@Controller
public class UserController {

	   private final UserService userService;
	    
	    public UserController(UserService userService) {
	        this.userService = userService;
	    }
	    
	    @RequestMapping("/registration")
	    public String registerForm(@ModelAttribute("user") User user) {
	        return "registrationPage.jsp";
	    }
	    @RequestMapping("/login")
	    public String login() {
	        return "loginPage.jsp";
	    }
	    
	    @RequestMapping(value="/registration", method=RequestMethod.POST)
	    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
	    	if (result.hasErrors()) {
	    		return "registrationPage.jsp";
	    	}
	    	User newuser=userService.registerUser(user);
	      session.setAttribute("userId",newuser.getId());
	      return"redirect:/home";
	    }
	    
	    @RequestMapping(value="/login", method=RequestMethod.POST)
	    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
	    	boolean isAuthenticated =userService.authenticateUser(email, password);
	    	if (isAuthenticated) {
	    		User user =userService.findByEmail(email);
	    		session.setAttribute("userId", user.getId());
	    		return "redirect:/home";
	    	} else {
	    		model.addAttribute("error","Invalid Credentials. Please try again.");
	    		return "loginPage.jsp";
	    				
	    	}
    }
	    
	    @RequestMapping("/home")
	    public String home(HttpSession session, Model model) {
	    	Long Id=(Long) session.getAttribute("userId");
	    	User newuser=userService.findUserById(Id);
	    	model.addAttribute("user", newuser);
	        return "homePage.jsp";
	    }
	    @RequestMapping("/logout")
	    public String logout(HttpSession session) {
	       session.invalidate();
	       return"redirect:/login";
	    }
	
	
	
}
