package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserBookController {
	
	@Autowired
	UserBookService userBookService;
	
	@RequestMapping("/")
	public String sayHello() {
		return "Hello UserBookTest is Running";
	}
	
	
	// using POST mapping for creating of user
	@PostMapping("/createUser")
	public List createUser(@RequestBody User user) {
		
		List userList = null;
		
		try {
		
		if(user != null)
			 userList = userBookService.createUser(user);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return userList;
		
	}
	
	// using get mapping to fetch the user and user's books FLAVOR -1 BY USING ID
	@GetMapping("/getUserBooks/{userId}")
	public Optional<User> getUserBooks(@PathVariable("userId") int userId) {
		
		Optional<User> userList = null;
		try {
		if(userId!=0) {
			System.out.println("userid:: "+userId);
			userList = userBookService.getUserBooks(userId);
		} 
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return userList;
	}
	
	//using get mapping to fetch the user and user's books FLAVOR -2 BY ENTIRE LIST
	
	@GetMapping("/getAllUserList")
	public List getAllUserList() {
		List userList = null;
		
		try {
			userList = userBookService.getAllUserList();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return userList;
	}
	
	//using put mapping for updating the user and books
	@PutMapping("/updateUserBooks/{userId}")
	public Optional<User> updateUserBooks(@PathVariable("userId") int userId, @RequestBody User user) {
		
		Optional<User> userList = null;
		try {
		if(userId!=0 && user!=null)
			userList = userBookService.updateUserBooks(userId, user);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return userList;
	}
	
	//using delete mapping for deleting the specific user and books
	@DeleteMapping("/deleteUserBooks/{userId}")
	public List deleteUserBooks(@PathVariable("userId") int userId) {
		
		List userList = null;
		
		try {
		
		if(userId!=0)
			userList = userBookService.deleteUserBooks(userId);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return userList;
		
	}
	
	
	

}
