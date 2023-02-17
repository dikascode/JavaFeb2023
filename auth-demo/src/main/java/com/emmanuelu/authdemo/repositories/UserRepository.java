package com.emmanuelu.authdemo.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.emmanuelu.authdemo.models.User;

public interface UserRepository extends CrudRepository<User, Long> {
	
	//find user by email interface method
	Optional<User> findByEmail(String email);

}
