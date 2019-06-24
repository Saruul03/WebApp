package com.example.demo.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Category;
import com.example.demo.repository.CategoryRepository;

@RestController
public class CategoryApiController {
	
	@Autowired
	private CategoryRepository repo;	
		
	@GetMapping("/api/category/list")
	public Iterable<Category> list() {
		return repo.findAll();		
	}
		
}
