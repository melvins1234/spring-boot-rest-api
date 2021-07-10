package com.rakutech.api.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rakutech.api.model.User;
import com.rakutech.api.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("")
	Collection<User> users(){
		return userRepository.findAll();
	}
	
//	@GetMapping("/{id}")
//	ResponseEntity<?> getUserById(@PathVariable Long id){
//		Optional<User> user = userRepository.findById(id);
//		return user.map(response -> ResponseEntity.ok().body(response))
//                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
//	}
	
	@GetMapping("/{value}")
	ResponseEntity<?> getUserByEmail(@PathVariable String value) throws NumberFormatException{
		Optional<User> user;
		if(value.contains("@")) 
			user= userRepository.findByEmailAddress(value);
		else
			user = userRepository.findById(Long.parseLong(value));
		
		return user.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	
    @PostMapping("")
    ResponseEntity<User> createUser(@RequestBody User user) throws URISyntaxException {
        User result = userRepository.save(user);
        System.out.println(result);
        return ResponseEntity.created(new URI("/users/group/" + result.getId()))
                .body(result);
    }
	
	@PutMapping("")
    ResponseEntity<User> updateGroup(@RequestBody User user) {
        User result = userRepository.save(user);
        return ResponseEntity.ok().body(result);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
