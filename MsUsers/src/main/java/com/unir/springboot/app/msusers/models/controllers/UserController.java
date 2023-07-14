package com.unir.springboot.app.msusers.models.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.unir.springboot.app.msusers.models.entity.User;
import com.unir.springboot.app.msusers.models.service.IUserService;

@RestController
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@GetMapping("/ver/{username}")
	public User Ver(@PathVariable String username) {
		return userService.findByUsername(username);
	}
	
	@GetMapping("/ver/id/{id}")
	public User Ver(@PathVariable Long id) {
		return userService.findById(id);
	}
	
	@GetMapping("/listar")
	public List<User> Listar(){
		return userService.findAll().stream().collect(Collectors.toList());
	}
	
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public User Create(@RequestBody User user) {
		return userService.save(user);
	}
	
	@PutMapping("/update/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public User Update(@RequestBody User user, @PathVariable Long id) {
		User userDb = userService.findById(id);
		userDb.setName(user.getName());
		userDb.setLastName(user.getLastName());
		return userService.save(userDb);
	}
	
	
	@DeleteMapping("/delete/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void Delete(@PathVariable Long id) {
		userService.DeleteById(id);
	}
	
	
}
