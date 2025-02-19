package com.gabrielpereira.workshopmongo.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabrielpereira.workshopmongo.domain.Post;
import com.gabrielpereira.workshopmongo.repository.PostRepository;
import com.gabrielpereira.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repository;
	
	public Post findById(String id) {
		Optional<Post> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public List<Post> findByTitle(String text){
		return repository.searchTitle(text);
	}
	
	public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
	    System.out.println("Text: " + text);
	    System.out.println("Min Date: " + minDate);
	    System.out.println("Max Date: " + maxDate);
	    maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
	    return repository.fullSearch(text, minDate, maxDate);
	}
}