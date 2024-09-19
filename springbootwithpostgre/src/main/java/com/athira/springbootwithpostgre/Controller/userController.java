package com.athira.springbootwithpostgre.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.athira.springbootwithpostgre.Model.UserEntity;
import com.athira.springbootwithpostgre.Service.UserService;

@RestController
@RequestMapping("/user")
public class userController {
	@Autowired
	private UserService userService;
	
	@GetMapping
	public List<UserEntity> getAllUser(){
		List<UserEntity> users = userService.getAllUser();
		System.out.println("user :"+ users);
		return users;
	}
	@GetMapping("/{userId}")
	public UserEntity getUserById(@PathVariable Integer userId) {
		UserEntity user = userService.getUserById(userId);
		System.out.println("userId :" + userId+ " :user :" + user);
		return user;
	}
	@PostMapping("/save")
	public String saveUser(@RequestBody UserEntity user) {
		userService.saveUser(user);
		return "user saved successfully";
	}
	@PutMapping("/{userId}")
	public String updateUser(@RequestBody UserEntity user , @PathVariable Integer userId) {
		userService.updateUser(user,userId);
		return "User Updated Successfully";
	}
	@DeleteMapping("/{userId}")
		public String deleteUserById(@PathVariable Integer userId) {
			userService.deleteUserById(userId);
			return "Deleted Successfully";
		}
	

}
