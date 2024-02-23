package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.User;
import com.example.service.UserService;

@RestController
@CrossOrigin
public class UserController {
	 
	@Autowired
	private UserService userService;
	
	@PostMapping("/saveUser")
	public ResponseEntity<?> saveUser(@RequestBody User user)
	{
		return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED); 
	}
	@PostMapping("/verifyUser")
	public ResponseEntity<?> verifyUser(@RequestBody userCredentials userCredentials)
	{
		String email = userCredentials.getEmail();
		String password = userCredentials.getPassword();
		return new ResponseEntity<>(userService.verifyUser(email, password),HttpStatus.OK);
	}
}
