package com.fernandes.twitterPostMysql.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fernandes.twitterPostMysql.entities.Post;
import com.fernandes.twitterPostMysql.repository.PostRepository;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	public List<Post> findAll() {
		List<Post> posts = postRepository.findAll();
		return posts;
	}

}
