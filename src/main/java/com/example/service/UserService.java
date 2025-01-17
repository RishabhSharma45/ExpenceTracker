package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.User;
import com.example.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userrepo;
	
	public User saveUsers(User u) {
		return userrepo.save(u);
	}
	
	public List<User> getUser() {
		return userrepo.findAll();
	}
}
