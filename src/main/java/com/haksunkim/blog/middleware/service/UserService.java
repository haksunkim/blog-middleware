package com.haksunkim.blog.middleware.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.haksunkim.blog.middleware.domain.Role;
import com.haksunkim.blog.middleware.domain.User;
import com.haksunkim.blog.middleware.repository.RoleRepository;
import com.haksunkim.blog.middleware.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public List<User> findAll() {	
		return (List<User>) userRepository.findAll();
	}
	
	public User save(User user) {
		// encrypt password and set it for saving user
		String encryptedPassword = bCryptPasswordEncoder.encode(user.getPassword());
		user.setPassword(encryptedPassword);
		
		return userRepository.save(user);		
	}
	
	public List<Role> findRoles() {
		return (List<Role>) roleRepository.findAll();
	}
	
	public Role findRoleByName(String name) {
		return roleRepository.findByName(name);
	}
}
