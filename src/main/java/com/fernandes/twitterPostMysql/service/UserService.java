package com.fernandes.twitterPostMysql.service;

import java.util.List;
import java.util.Optional;

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
	
	// teste caso ele pode não achar o usuario informado
	public Optional<User> findById(Integer id) {
		Optional<User> user = userRepository.findById(id);
		
		return user;
	}

}
