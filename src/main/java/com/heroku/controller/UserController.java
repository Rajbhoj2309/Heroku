package com.heroku.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.heroku.model.User;
import com.heroku.repository.UserRepository;
import com.heroku.repository.UserRepositoryA;
import com.heroku.repository.UserRepositoryQ;

@Controller
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserRepositoryA userRepositoryA;
	
	@Autowired
	private UserRepositoryQ userRepositoryQ;
//Circular view path [add]: would dispatch back to the current handler URL [/add] again. 
//	Check your ViewResolver setup! (Hint: This may be the result of an unspecified view, 
//	due to default view name generation.)	
	@PostMapping("/add")
	public User userAdd(@RequestBody User user) {
		User save = userRepository.save(user);
		return save;
	}
	
	@PostMapping("/add1")
	public ResponseEntity<User>saveUser(@RequestBody User user){
		if(userRepository.existsById(user.getId())) {
			return new ResponseEntity<>( HttpStatus.CONFLICT);
		}
		return new ResponseEntity<>(userRepository.save(user),HttpStatus.CREATED);
	}
	
	 @GetMapping("/findname/{name}")
	    public ResponseEntity<User> getUserByName(@PathVariable String name) {
	        Optional<User> optionalUser = userRepositoryA.findByName(name);

	        return optionalUser
	                .map(user -> new ResponseEntity<>(user, HttpStatus.OK))
	                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	    }
	
	
	@GetMapping("/findusername/{username}")
	public ResponseEntity<User> getUserName(@PathVariable String username){
	Optional<User> findByUserName = userRepositoryA.findByUserName(username);
	if (findByUserName.isEmpty()) {
		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	}
	return new ResponseEntity<User>(HttpStatus.FOUND);
	}
	
	
//	@GetMapping("/maxId")
//    public ResponseEntity<Long> getMaxUserId() {
//        Long maxId = userRepositoryQ.findMaxId();
//
//        if (maxId != null) {
//            return new ResponseEntity<>(maxId, HttpStatus.OK);
//        } else {
//            // Handle the case where the result is null (e.g., no users in the database)
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
	

	

}
