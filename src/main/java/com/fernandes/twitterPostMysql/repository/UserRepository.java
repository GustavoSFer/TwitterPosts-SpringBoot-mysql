package com.fernandes.twitterPostMysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fernandes.twitterPostMysql.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
