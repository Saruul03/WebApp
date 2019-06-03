package com.example.demo.controller.admin;

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

import com.example.demo.domain.Category;
import com.example.demo.model.CategoryForm;
import com.example.demo.repository.CategoryRepository;

@Controller
public class CategoryAdminController {
	
	@Autowired
	private CategoryRepository repo;
	
	@RequestMapping("/admin/category")
	public String index() {		
		return "category-index";
	}
	
	@GetMapping("/admin/category/list")
	public String list(Model modelNer) {
		modelNer.addAttribute("angilluud", repo.findAll());		
		return "angilliinJagsaalt";
	}
	
	@RequestMapping("/admin/category/edit")
	public String edit(@RequestParam Integer id, Model model) {
		Category category = repo.findById(id).get();
		
		CategoryForm form = new CategoryForm();
		form.setId(category.getId());
		form.setNer(category.getName());
		form.setTailbar(category.getDescription());
				
		model.addAttribute("jspForm", form);
				
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
	public void save(CategoryForm form) {
		Category category = new Category();
		
		category.setName(form.getNer());
		category.setDescription(form.getTailbar());
		
		repo.save(category);					
	}

	@PostMapping("/admin/category/update")
	@ResponseBody
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void update(CategoryForm form) {
		Category category = repo.findById(form.getId()).get();		
				
		category.setName(form.getNer());
		category.setDescription(form.getTailbar());
		
		repo.save(category);					
	}
	
	@PostMapping("/admin/category/delete/{id}")
	@ResponseBody
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteCategory(@PathVariable Integer id) {
		Category category = repo.findById(id).get();								
		repo.delete(category);
	}

	
}
