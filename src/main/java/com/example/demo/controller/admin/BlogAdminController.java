package com.example.demo.controller.admin;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.demo.domain.Blog;
import com.example.demo.model.BlogForm;
import com.example.demo.repository.BlogRepository;

@Controller
@RequestMapping("/admin/blog")
public class BlogAdminController {
	
	@Autowired
	private BlogRepository repo;
	
	@RequestMapping
	public String index() {		
		return "blogIndex";
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("blogs", repo.findAll());		
		return "blogList";
	}
	
	@RequestMapping("/edit")
	public String edit(@RequestParam Integer id, Model model) {
		Blog blog = repo.findById(id).get();
		
		BlogForm form = new BlogForm();
		form.setId(blog.getBlogId());
		form.setName(blog.getName());
		form.setContent(blog.getContent());
				
		model.addAttribute("jspForm", form);
				
		return "blogEdit";
	}
	
	@RequestMapping("/new")
	public String newForm(Model model) {	
		model.addAttribute("jspForm", new BlogForm());
		return "blogNew";
	}
		
	@PostMapping("/save")
	@ResponseBody
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
				
		repo.save(blog);					
	}
	
	@PostMapping("/delete/{id}")
	@ResponseBody
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteCategory(@PathVariable Integer id) {
		Blog blog = repo.findById(id).get();								
		repo.delete(blog);
	}

	
}
