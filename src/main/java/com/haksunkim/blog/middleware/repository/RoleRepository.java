package com.haksunkim.blog.middleware.repository;

import org.springframework.data.repository.CrudRepository;

import com.haksunkim.blog.middleware.domain.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {
	Role findByName(String name);
}
