package com.example.demo.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.demo.domain.User;
import com.example.demo.model.UserEditForm;
import com.example.demo.model.UserNewForm;
import com.example.demo.repository.UserRepository;

@Controller
@RequestMapping("/admin/user")
public class UserController {
	
	@Autowired
	private UserRepository repo;
	
	@GetMapping
	public String main() {
		return "admin-user";
	}
	
	@GetMapping("list")
	public String list(Model model) {
		model.addAttribute("list", repo.findAll());
		return "admin-user-list";
	}
	
	@PostMapping("save")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void save(UserNewForm form) {
	
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		User user = new User();
		
		user.setUsername(form.getUsername());
		user.setPassword(encoder.encode(form.getPassword()));
		user.setEnabled(Boolean.TRUE);
		
		repo.save(user);
	}
	
	@PostMapping("update")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void edit(UserEditForm form) {
				
		User user = repo.findById(form.getOldUsername()).get();
		
		user.setUsername(form.getUsername());		
		user.setEnabled(Boolean.TRUE);
		
		repo.save(user);
		
	}
	
	@RequestMapping("new")
	public String newForm() {		
		return "admin-user-new";
	}
	
	@RequestMapping("{username}/edit")
	public String editForm(@PathVariable String username, Model model) {
		UserEditForm form = new UserEditForm();
		
		User user = repo.findById(username).get();
		
		form.setOldUsername(user.getUsername());
		form.setUsername(user.getUsername());
		form.setEnabled(user.getEnabled());
		
		model.addAttribute("jspForm", form);
		
		return "admin-user-edit";
	}

}
