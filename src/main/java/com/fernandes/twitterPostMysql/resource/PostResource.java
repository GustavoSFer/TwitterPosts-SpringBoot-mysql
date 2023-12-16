package com.fernandes.twitterPostMysql.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fernandes.twitterPostMysql.entities.Post;
import com.fernandes.twitterPostMysql.service.PostService;

@RestController
@RequestMapping(value = "/orders")
public class PostResource {
	
	@Autowired
	private PostService postService;
	
	@GetMapping
	public ResponseEntity<List<Post>> findAll() {
		List<Post> posts = postService.findAll();
		
		return ResponseEntity.ok().body(posts);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Post> findById(@PathVariable Integer id) {
		Post post = postService.findById(id);
		
		return ResponseEntity.ok().body(post);
	}

}