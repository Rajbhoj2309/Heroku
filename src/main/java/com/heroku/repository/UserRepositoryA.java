package com.heroku.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.heroku.model.User;

public interface UserRepositoryA extends JpaRepository<User, Long>{
	
	Optional<User> findByName(String name);
	Optional<User> findByUserName(String username);
	

}
