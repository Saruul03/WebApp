package com.example.demo.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.demo.domain.Menu;

public interface MenuRepository extends PagingAndSortingRepository<Menu, Integer>{
	
}



