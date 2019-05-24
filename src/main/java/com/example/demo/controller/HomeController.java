package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String indexdfdfoer(Model model) {
		model.addAttribute("name", "Erdenetsogt");
		return "home";
	}
	
	@RequestMapping("/about")
	public String indexdfdfsoesadadr() {
		return "about";
	}

}
