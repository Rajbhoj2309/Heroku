package com.heroku.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.heroku.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
