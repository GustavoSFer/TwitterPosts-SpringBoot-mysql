package com.fernandes.twitterPostMysql.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fernandes.twitterPostMysql.entities.User;
import com.fernandes.twitterPostMysql.repository.UserRepository;
import com.fernandes.twitterPostMysql.service.exception.DatabaseException;
import com.fernandes.twitterPostMysql.service.exception.NullPointerBadRequestException;
import com.fernandes.twitterPostMysql.service.exception.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

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
		try {
			if (obj.getName().isEmpty() || obj.getEmail().isEmpty()) {
				throw new NullPointerException();
			}
			return userRepository.save(obj);
		} catch (NullPointerException e) {
			throw new NullPointerBadRequestException("Nãp foi possivel criar o usuario!");
		}
	}

	public User update(Integer id, User obj) {
		try {
			User user = findById(id);
			updateUser(user, obj);
			return userRepository.save(user);
		} catch (EntityNotFoundException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	public void updateUser(User user, User obj) {
		user.setName(obj.getName());
		user.setEmail(obj.getEmail());
	}

	public User delete(Integer id) {
		User user = findById(id);
		userRepository.delete(user);
		return user;
	}
}
