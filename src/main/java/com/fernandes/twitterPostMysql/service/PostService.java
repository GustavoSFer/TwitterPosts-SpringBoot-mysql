package com.fernandes.twitterPostMysql.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fernandes.twitterPostMysql.entities.Post;
import com.fernandes.twitterPostMysql.entities.User;
import com.fernandes.twitterPostMysql.repository.PostRepository;
import com.fernandes.twitterPostMysql.service.exception.ResourceNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	public List<Post> findAll() {
		List<Post> posts = postRepository.findAll();
		return posts;
	}
	
	public Post findById(Integer id) {
		Optional<Post> post = postRepository.findById(id);
		
		return post.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Post create(Post obj) {
		Post post = postRepository.save(obj);
		return post;
	}
	
	public Post update(Post obj, Integer id) {
		Post post = findById(id);
		updatePost(obj, post);
		 postRepository.save(post);
		return post;
	}
	
	private void updatePost(Post obj, Post post) {
		post.setTexto(obj.getTexto());
		post.setTitulo(obj.getTitulo());
		post.setUser(obj.getUser());;
	}

}
