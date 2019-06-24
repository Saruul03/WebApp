package com.example.demo.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Category;
import com.example.demo.model.CategoryForm;
import com.example.demo.repository.CategoryRepository;

@RestController
public class CategoryApiController {
	
	@Autowired
	private CategoryRepository repo;	
		
	@GetMapping("/api/category/list")
	public Iterable<Category> list() {
		return repo.findAll();		
	}
		
	@PostMapping("/api/category/save")	
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void save(CategoryForm form) {			
		Category category = new Category();		
		category.setName(form.getNer());
		category.setDescription(form.getTailbar());		
		repo.save(category);			
	}
}
