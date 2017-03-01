package com.haksunkim.blog.middleware.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.haksunkim.blog.middleware.rabbitmq.Producer;

@Controller
public class UserController {
	
	@Autowired
	private Producer producer;
	private static final String EXCHANGE_NAME = "blog";
	private static final String USER_ROUTING_KEY = "blog.user";
	
	@RequestMapping(value="/users", method=RequestMethod.GET)
	@ResponseBody
	public String findAll() {
		String response = "";
		String message = "{\"route\":\"/users\",\"method\":\"get\"}";
		
		response = producer.sendTo(EXCHANGE_NAME, USER_ROUTING_KEY, message);
		
		return response;
	}
}
