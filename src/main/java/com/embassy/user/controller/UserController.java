package com.embassy.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import com.embassy.user.dao.entity.User;
import com.embassy.user.service.IUserService;

@Controller
@RequestMapping("rest/fms/")
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	
	@GetMapping("user/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") Integer id) {
		User user = userService.viewUser(id);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@GetMapping("user/activate/{id}")
	public ResponseEntity<Boolean> activateUserById(@PathVariable("id") Integer id) {
		boolean user = userService.activateUser(id);
		return new ResponseEntity<Boolean>(user, HttpStatus.OK);
	}
	
	@GetMapping("user/deactivate/{id}")
	public ResponseEntity<Boolean> deactivateUserById(@PathVariable("id") Integer id) {
		boolean user = userService.deactivateUser(id);
		return new ResponseEntity<Boolean>(user, HttpStatus.OK);
	}
	
	@GetMapping("user/lock/{id}")
	public ResponseEntity<Boolean> lockUserById(@PathVariable("id") Integer id) {
		boolean user = userService.activateUser(id);
		return new ResponseEntity<Boolean>(user, HttpStatus.OK);
	}
	
	@GetMapping("user/unlock/{id}")
	public ResponseEntity<Boolean> unlockUserById(@PathVariable("id") Integer id) {
		boolean user = userService.deactivateUser(id);
		return new ResponseEntity<Boolean>(user, HttpStatus.OK);
	}
	
	@GetMapping("user/reset/{id}")
	public ResponseEntity<Boolean> resetPasswordUserById(@PathVariable("id") Integer id) {
		boolean user = userService.resetPassword(id);
		return new ResponseEntity<Boolean>(user, HttpStatus.OK);
	}
	
	@GetMapping("users")
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> list = userService.getUserList();
		return new ResponseEntity<List<User>>(list, HttpStatus.OK);
	}
	
	
	@PostMapping("user/create")
	public ResponseEntity<Void> addArticle(@RequestBody User user, UriComponentsBuilder builder) {
		User currentUser = userService.createUser(user);
		if (currentUser == null) {
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/user/{id}").buildAndExpand(user.getUserId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@PostMapping("user/update")
	public ResponseEntity<User> updateArticle(@RequestBody User user) {
		userService.updateUser(user);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	

}
