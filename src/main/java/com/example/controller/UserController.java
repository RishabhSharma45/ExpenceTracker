package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.User;
import com.example.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService us;
	
	@GetMapping("/User")
	public List<User> getUser() {
		return this.us.getUser();
	}
	
	@PostMapping("/add")
	public User addUser(@RequestBody User u) {
		return this.us.saveUsers(u);
	}

}
