package com.stsoft.demospring.controller;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.stsoft.demospring.entity.Role;
import com.stsoft.demospring.entity.User;
import com.stsoft.demospring.repository.UserRepository;

@Controller

public class RegistrationController {
	@Autowired
	private UserRepository userRepository;
	
    @GetMapping("/registration")
    public String registration() {
    	return "registration";
    }
    	
    @PostMapping("/registration")
    public String addUser(User user, Model model) {
    	User userFromDb = userRepository.findByUsername(user.getUsername());
    	if (userFromDb != null) {
    		model.addAttribute("message", "User exists!");
    		return "registration";
    	}
    	user.setActive(true);
    	user.setRoles(Collections.singleton(Role.USER));
    	userRepository.save(user);
    	return "redirect:/login";
    }

}
