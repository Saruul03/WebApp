package com.example.demo.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Menu;
import com.example.demo.model.MenuForm;
import com.example.demo.repository.MenuRepository;

@RestController
@RequestMapping("api/menu")
public class MenuApiController {
	
	//Шинэ ангилал хадгалах
	@PostMapping("/save")
	@ResponseBody
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void save(MenuForm form) {
		
		
		Menu menu = new Menu();
		menu.setName(form.getName());
		menu.setLink(form.getLink());
		menu.setOrdering(form.getOrdering());
		menu.setTarget(form.getTarget());
		repo.save(menu);
	}
	
	
	
	@Autowired
	private MenuRepository repo;
	@GetMapping("/list")
	public Iterable<Menu> list() {
		return repo.findAll();
	}
		
	
	//Хуучин ангилал засах
	@PostMapping("/update")	
	@ResponseBody
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void update1(MenuForm form) {
		Menu menu = repo.findById(form.getId()).get();				
		menu.setName(form.getName());
		menu.setLink(form.getLink());
		menu.setOrdering(form.getOrdering());
		menu.setTarget(form.getTarget());		
		
		repo.save(menu);		
	}
	
	{}
	
	//Ангилал унших
	@GetMapping("/api/category/read/{id}")
	@ResponseBody
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void update(MenuForm form) {
		Menu menu = repo.findById(form.getId()).get();				
		menu.setName(form.getName());
		menu.setLink(form.getLink());
		menu.setOrdering(form.getOrdering());
		menu.setTarget(form.getTarget());		
	
	}
	
	//Ангилал устгах
	@PostMapping("/delete/{id}")
	@ResponseBody
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteCategory(@PathVariable Integer id) {
		Menu menu = repo.findById(id).get();								
		repo.delete(menu);
		
	}
	

}

