package com.gabrielpereira.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabrielpereira.workshopmongo.domain.User;
import com.gabrielpereira.workshopmongo.dto.UserDTO;
import com.gabrielpereira.workshopmongo.repository.UserRepository;
import com.gabrielpereira.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService{
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(String id) {
		Optional<User> user = repository.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public User insert(User obj) {
		return repository.insert(obj);
	}
	public void delete(String id) {
		findById(id);
		repository.deleteById(id);
	}
	
	public User update(User obj) {
		User newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repository.save(newObj);
	}
	
	private void updateData(User newObj, User obj) {
		newObj.setEmail(obj.getEmail());
		newObj.setName(obj.getName());
		
	}

	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
	
}
