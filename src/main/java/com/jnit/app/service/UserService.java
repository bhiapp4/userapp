package com.jnit.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jnit.app.dao.UserRepository;
import com.jnit.app.exceptions.NotFoundException;
import com.jnit.app.model.User;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User createUser(User user) throws Exception{
		return userRepository.save(user);
	}

	public User updateUser(User user) throws Exception{
		return userRepository.save(user);
	}

	public void deleteUser(Long userId) throws Exception{
		User user = userRepository.findOne(userId);
		if(user == null){
			throw new NotFoundException("User with "+userId+" not found");
		}
		userRepository.delete(userId);
	}

	public List<User> getAllUsers() throws Exception{
		return userRepository.findAll();
	}
	
	public User getUserById(Long userId)throws Exception{
		return userRepository.findOne(userId);
	}
	
}
