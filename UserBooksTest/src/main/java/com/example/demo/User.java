package com.example.demo;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="user_info")
public class User {
	
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private int userId;
	@Column
	private String userName;
	@OneToMany(targetEntity=Books.class,cascade = CascadeType.ALL)
	private Set<Books> bookList;
	
	
	
	public Set<Books> getBookList() {
		return bookList;
	}
	public void setBookList(Set<Books> bookList) {
		this.bookList = bookList;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	

}
