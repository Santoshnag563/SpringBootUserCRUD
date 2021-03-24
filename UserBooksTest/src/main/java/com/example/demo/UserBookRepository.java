package com.example.demo;

import org.springframework.data.repository.CrudRepository;

public interface UserBookRepository extends CrudRepository<User,Integer> {

}
