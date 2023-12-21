package com.jpa.test.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.jpa.test.dao.UserRepository;

public class controller {
	
	@Autowired
	UserRepository repository;
	
	
	private void details() {
		repository.save(null);

	}

}
