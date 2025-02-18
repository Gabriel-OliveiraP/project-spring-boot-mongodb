package com.gabrielpereira.workshopmongo.dto;

import java.io.Serializable;

import com.gabrielpereira.workshopmongo.domain.User;

public class AuthorDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	
	public AuthorDTO() {
		
	}
	public AuthorDTO(User obj) {
		this.id = obj.getId();
		this.name = obj.getName();
	}
	
}
