package com.gabrielpereira.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.gabrielpereira.workshopmongo.domain.Post;

@Repository
public interface PostRepository  extends MongoRepository<Post, String>{

	List<Post> findByTitleContainingIgnoreCase(String text);
}
