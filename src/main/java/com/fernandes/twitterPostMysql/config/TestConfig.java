package com.fernandes.twitterPostMysql.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.fernandes.twitterPostMysql.entities.User;
import com.fernandes.twitterPostMysql.repository.UserRepository;

@Configuration
@Profile("mysql")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {

		User p1 = new User(null, "Joãozinha da Silva", "joao@gmail.com");
		User p2 = new User(null, "Luiz Henrique", "lulu@gmail.com");
		User p3 = new User(null, "Zelia Brow", "zelia@gmail.com");
		
		userRepository.saveAll(Arrays.asList(p1, p2, p3));		
		
	}

}
