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
	  
	  
	  //Find all users
	  public List<User> findAllUsers() {
		  return userRepo.findAll();
	  }
	  
	  public User createUser(User writer) {
		  return userRepo.save(writer);
	  }

}
