package com.example.demo.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.demo.domain.User;

public interface UserRepository extends PagingAndSortingRepository<User, String>{

}
