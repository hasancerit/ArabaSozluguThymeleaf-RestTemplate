package com.example.ArabaSozluguTh.ArabaSozluguTh.controller;

import java.security.Principal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecController {
	@GetMapping("/")
	public String hello(Model model,Principal p) {
		return "hello";
	}
	
	@GetMapping("/admin")
	public String admin(Model model,Principal p) {
		return "admin";
	}
	
	@GetMapping("/user")
	public String user(Model model) {
		return "user";
	}

}

