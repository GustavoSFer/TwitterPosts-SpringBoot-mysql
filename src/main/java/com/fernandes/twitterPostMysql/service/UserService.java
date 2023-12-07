package com.fernandes.twitterPostMysql.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fernandes.twitterPostMysql.entities.User;
import com.fernandes.twitterPostMysql.repository.UserRepository;
import com.fernandes.twitterPostMysql.service.exception.DatabaseException;
import com.fernandes.twitterPostMysql.service.exception.ResourceNotFoundException;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public List<User> findAll() {
		List<User> users = userRepository.findAll();
		return users;
	}
	
	public User findById(Integer id) {
		Optional<User> user = userRepository.findById(id);
		
		return user.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public User create(User obj) {
		String nome = obj.getName();
		if (obj.getName().isEmpty() || obj.getEmail().isEmpty()) {
			throw new DatabaseException("Não foi possivel adicionar a pessoa!");
		}
		return userRepository.save(obj);
	}

}
