package com.fernandes.twitterPostMysql.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fernandes.twitterPostMysql.entities.User;
import com.fernandes.twitterPostMysql.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public List<User> findAll() {
		List<User> users = userRepository.findAll();
		return users;
	}

}
