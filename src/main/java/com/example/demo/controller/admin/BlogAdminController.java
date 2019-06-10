package com.example.demo.controller.admin;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.demo.domain.Blog;
import com.example.demo.domain.Category;
import com.example.demo.model.BlogForm;
import com.example.demo.repository.BlogRepository;
import com.example.demo.repository.CategoryRepository;

@Controller
@RequestMapping("/admin/blog")
public class BlogAdminController {
	
	@Autowired
	private BlogRepository repo;
	
	@Autowired
	private CategoryRepository categoryRepo;
	
	@RequestMapping
	public String index() {		
		return "blogIndex";
	}
	
	@GetMapping("/list")
	public String list(Model model, Pageable pageable) {
		model.addAttribute("blogs", repo.findAll(pageable));		
		return "blogList";
	}
	
	
	@GetMapping("/listJson")
	public String list() {
		return "temdegt";		
	}
	
	@RequestMapping("/edit")
	public String edit(@RequestParam Integer id, Model model) {
		Blog blog = repo.findById(id).get();
		
		BlogForm form = new BlogForm();
		form.setId(blog.getBlogId());
		form.setName(blog.getName());
		form.setContent(blog.getContent());
		if (blog.getCategory()!=null) {
			form.setCategoryId(blog.getCategory().getId());	
		}				
				
		model.addAttribute("jspForm", form);
		
		model.addAttribute("categories", categoryRepo.findAll());
				
		return "blogEdit";
	}
	
	@RequestMapping("/new")
	public String newForm(Model model) {	
		model.addAttribute("jspForm", new BlogForm());
		
		model.addAttribute("categories", categoryRepo.findAll());
		
		return "blogNew";
	}
		
	@PostMapping("/save")	
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void save(BlogForm form) {
		
		Blog blog;
		
		if (form.getId()==null) {
			blog = new Blog();
			blog.setCreated(new Date());
		}
		else {
			blog = repo.findById(form.getId()).get();
		}
					
		blog.setName(form.getName());
		blog.setContent(form.getContent());
		
		Category category = null;
		if (form.getCategoryId()!=null && form.getCategoryId()!=0) {
			category = categoryRepo.findById(form.getCategoryId()).get();
		}
		
		blog.setCategory(category);
				
		repo.save(blog);					
	}
	
	@PostMapping("/delete/{id}")	
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteCategory(@PathVariable Integer id) {
		Blog blog = repo.findById(id).get();								
		repo.delete(blog);
	}

	
}
