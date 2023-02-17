package com.emmanuelu.authdemo.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.emmanuelu.authdemo.models.LoginUser;
import com.emmanuelu.authdemo.models.User;
import com.emmanuelu.authdemo.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;

	// TO-DO: Write register and login methods!
	public User register(User newUser, BindingResult result) {
		//Firstly check if there's a user existing with the email put in for registration
		Optional<User> optionaluser = userRepo.findByEmail(newUser.getEmail());

		//If such user exist pass in an error message to binding result
		if (optionaluser.isPresent()) {
			result.rejectValue("email", "unique", "This email already exists");
		}

		//compare user's registration password with confirm password
		//if there's a mismatch insert an error message to binding result
		if (!newUser.getPassword().equals(newUser.getConfirm())) {
			result.rejectValue("confirm", "matches", "Your password does not match");
		}

		//If errors exist return null
		if (result.hasErrors()) {
			return null;
		}

		String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());

		// Set the password
		newUser.setPassword(hashed);

		userRepo.save(newUser);

		return newUser;
	}

	public User login(LoginUser loginUser, BindingResult result) {
		// TO-DO: Additional validations!
		Optional<User> optionaluser = userRepo.findByEmail(loginUser.getEmail());

		//check if user's email exists otherwise return null
		if (!optionaluser.isPresent()) {
			result.rejectValue("email", "unavailable", "This is email has not been registered");
			return null;
		}
		
		//Get the user record
		User user = optionaluser.get();
		
		//Check if loginUser password match user password in database
		if(!BCrypt.checkpw(loginUser.getPassword(), user.getPassword())) {
    	    result.rejectValue("password", "matches", "Invalid Password!");
    	}
		
		if(result.hasErrors()) {
			return null;
		}
		
		return user;
	}

}
