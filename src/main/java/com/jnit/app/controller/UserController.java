package com.jnit.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jnit.app.model.User;
import com.jnit.app.service.UserService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("users")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping
	public User createUser(@RequestBody @Valid User user) throws Exception {
		return userService.createUser(user);
	}

	@PutMapping
	public User updateUser(@RequestBody User user) throws Exception {
		return userService.updateUser(user);
	}

	@DeleteMapping(value="/{userId}")
	public ResponseEntity<HttpStatus> deleteUser(@PathVariable("userId") Long userId) throws Exception {
		userService.deleteUser(userId);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	@GetMapping
	public List<User> getAllUsers() throws Exception {
		return userService.getAllUsers();
	}
	
	@GetMapping("/{userId}")
	public User getUserById(@PathVariable("userId")Long userId) throws Exception{
		return userService.getUserById(userId);
	}
}
