package com.fernandes.twitterPostMysql.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.fernandes.twitterPostMysql.entities.Post;
import com.fernandes.twitterPostMysql.entities.User;
import com.fernandes.twitterPostMysql.repository.PostRepository;
import com.fernandes.twitterPostMysql.repository.UserRepository;

@Configuration
@Profile("mysql")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {

		User p1 = new User(null, "Joãozinha da Silva", "joao@gmail.com");
		User p2 = new User(null, "Luiz Henrique", "lulu@gmail.com");
		User p3 = new User(null, "Zelia Brow", "zelia@gmail.com");
		
		Post post1 = new Post(null,  Instant.parse("2023-05-12T03:00:05Z"), "Titulo 1", "Meu primeiro post", p1);
		Post post2 = new Post(null,  Instant.parse("2023-05-12T03:00:05Z"), "Titulo 1", "Meu primeiro post", p1);
		
		userRepository.saveAll(Arrays.asList(p1, p2, p3));		
		
		postRepository.saveAll(Arrays.asList(post1,post2));
		
	}

}
