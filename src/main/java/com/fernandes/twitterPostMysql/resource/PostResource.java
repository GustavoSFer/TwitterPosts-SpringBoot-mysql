package com.fernandes.twitterPostMysql.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

	@PostMapping
	public ResponseEntity<Post> create(@RequestBody Post obj) {
		Post post = postService.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).body(post);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Post> update(@RequestBody Post obj, @PathVariable Integer id) {
		Post postUpdate = postService.update(obj, id);
		
		return ResponseEntity.ok().body(postUpdate);
	}
	
}
