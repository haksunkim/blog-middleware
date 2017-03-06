package com.haksunkim.blog.middleware.repository;

import org.springframework.data.repository.CrudRepository;

import com.haksunkim.blog.middleware.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);
}
