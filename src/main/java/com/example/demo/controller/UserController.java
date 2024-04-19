package com.example.demo.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.UserDto;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

@Controller
public class UserController {

	private UserService userService;
	private UserDetailsService userDetailsService; // Declaration

	@Autowired
	public UserController(UserService userService, UserDetailsService userDetailsService) {
		this.userService = userService;
		this.userDetailsService = userDetailsService; // Initialize the field
	}

	@GetMapping("/home")
	public String home(Model model, Principal principal) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
		model.addAttribute("userdetail", userDetails);
		return "home";
	}

	@GetMapping("/login")
	public String login(Model theModel, UserDto userDto) {

		theModel.addAttribute("user", userDto);
		return "login";
	}

	@GetMapping("/register")
	public String register(Model theModel, UserDto userDto) {
		theModel.addAttribute("user", userDto);
		return "register";
	}

	@PostMapping("/register")
	public String registerSave(@ModelAttribute("user") UserDto userDto, Model theModel) {
		//logic to find user is already registered or not
		User user = userService.findByUsername(userDto.getUsername());
		if(user != null) {
			theModel.addAttribute("userexist", user);
			return "register";
		}
		userService.save(userDto);
		return "redirect:/register?success";
	}
}
