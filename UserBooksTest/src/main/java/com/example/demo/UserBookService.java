package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserBookService {
	
	@Autowired
	UserBookRepository userBookRepository;
	
	
	
	public List createUser(User user) {
		
		try {
		
		 userBookRepository.save(user);
		 
		 
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return (List) userBookRepository.findAll();
		
		
	}



	public Optional<User> getUserBooks(int userId) {
		// TODO Auto-generated method stub
		
		Optional<User>  userList = null;
		try {
			userList = userBookRepository.findById(userId);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return userList;
	}



	public Optional<User> updateUserBooks(int userId, User user) {
		// TODO Auto-generated method stub
		
		
		Optional<User> userList = null;
		Optional<User> user1 = userBookRepository.findById(userId);
		
		try {
		
		if(user1 != null) {
		
		User user2=user1.get();
		 user2.setUserName(user.getUserName());
		 user2.setBookList(user.getBookList());
		 
		 userBookRepository.save(user2);
		 userList = userBookRepository.findById(userId);
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		 
		 return userList;
	}



	public List deleteUserBooks(int userId) {
		// TODO Auto-generated method stub
		
		List userList = null;
		
		try {
			userBookRepository.deleteById(userId);
			userList = (List) userBookRepository.findAll();
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return userList;
		
		
	}



	public List getAllUserList() {
		// TODO Auto-generated method stub
		
		List userList = null;
		try {
			userList = (List) userBookRepository.findAll();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return userList;
	}

	
	
	

}
