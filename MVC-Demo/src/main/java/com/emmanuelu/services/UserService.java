package com.emmanuelu.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emmanuelu.models.User;
import com.emmanuelu.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	
	 public List<User>returnAllUsers() {
	    	return userRepo.findAll();
	    }
	    
	    public User createUser(User user) {
	    	return userRepo.save(user);
	    }

}
