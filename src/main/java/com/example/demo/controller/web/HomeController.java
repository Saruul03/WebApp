package com.example.demo.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repository.BlogRepository;
import com.example.demo.repository.CategoryRepository;

@Controller
public class HomeController {
	
	@Autowired
	private BlogRepository blogRepo;
	
	@Autowired
	private CategoryRepository categoryRepo;
	
	@RequestMapping("/")
	public String indexdfdfoer(Model model) {				
		model.addAttribute("categories", categoryRepo.findAll());
		model.addAttribute("blogs", blogRepo.findAll());		
		return "index";
	}
	
	@RequestMapping("/blog/{id}")
	public String readblog(Model model, @PathVariable Integer id) {				
		model.addAttribute("categories", categoryRepo.findAll());
		model.addAttribute("blog", blogRepo.findById(id).get());		
		return "blog";
	}
	

}
