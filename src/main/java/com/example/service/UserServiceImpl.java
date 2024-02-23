package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.User;
import com.example.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService  {
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public User saveUser(User user) {
		return userRepo.save(user);
	}

	@Override
	public String verifyUser(String email, String password) {
		User user= userRepo.findByEmailAndPassword(email, password);
		if(user!=null)
		{
			return "User Exists";
		}
		return "Email and Password Doesn't Match";
	}
}
