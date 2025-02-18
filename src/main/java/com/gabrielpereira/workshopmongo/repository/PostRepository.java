package com.gabrielpereira.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.gabrielpereira.workshopmongo.domain.Post;

@Repository
public interface PostRepository  extends MongoRepository<Post, String>{

}
