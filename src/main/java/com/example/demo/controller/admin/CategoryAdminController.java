package com.example.demo.controller.admin;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class CategoryAdminController {
	
	@RequestMapping("/admin/category")
	public String index() {		
		return "category-index";
	}
	
	@GetMapping("/admin/category/list")
	public String list() {		
		return "angilliinJagsaalt";
	}
	
	@RequestMapping("/admin/category/edit")
	public String edit(@RequestParam Integer id) {		
		System.out.println(id);
		return "category-edit";
	}
	
	@RequestMapping("/admin/category/new")
	public String newForm() {		
		return "category-new";
	}
	
	@RequestMapping("/admin/category/sort")
	public String sort() {		
		return "category-sort";
	}
	
	@PostMapping("/admin/category/save")
	@ResponseBody
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void saveForm() {		
		System.out.println("saving to database");			
	}

}
