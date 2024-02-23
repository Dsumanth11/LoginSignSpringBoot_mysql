package com.example.service;
import com.example.model.User;

public interface UserService {
	public User saveUser(User user);
	public String verifyUser(String email, String password);
}
