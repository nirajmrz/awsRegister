package com.niraj.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.niraj.Entity.User;
import com.niraj.Repository.UserRepository;

@CrossOrigin(origins="*", allowedHeaders = "*")
@RestController
public class UserController {

	
	@Autowired
	private UserRepository repo;
	
	@GetMapping("/")
	public List<User> listUser(){
		return repo.findAll();
	}
	
	@PostMapping("/save")
	public User newUser(@RequestBody User user) {
		return repo.save(user);
	}
	
	@GetMapping("/{id}")
	public User getUser(@PathVariable(name="id") int id) {
		return repo.findById(id).orElse(null);
	}
	
	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable(name="id") int id) {
		repo.deleteById(id);
		return "User Deleted";
	}
	
	@PutMapping("/update")
	public User updateUser(@RequestBody User user) {
		return repo.save(user);
	}
}
