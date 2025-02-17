package com.gabrielpereira.workshopmongo.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabrielpereira.workshopmongo.domain.User;
import com.gabrielpereira.workshopmongo.repository.UserRepository;

@Service
public class UserService implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
}
