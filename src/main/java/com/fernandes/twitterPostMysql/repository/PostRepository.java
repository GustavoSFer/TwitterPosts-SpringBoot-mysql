package com.fernandes.twitterPostMysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fernandes.twitterPostMysql.entities.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
