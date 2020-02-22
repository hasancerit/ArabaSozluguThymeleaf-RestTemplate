package com.example.ArabaSozluguTh.ArabaSozluguTh.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ldap.embedded.EmbeddedLdapProperties.Credential;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.ArabaSozluguTh.ArabaSozluguTh.dto.ResponseDTO.post.PostResDTO;
import com.example.ArabaSozluguTh.ArabaSozluguTh.service.PostService;
import com.example.ArabaSozluguTh.ArabaSozluguTh.service.UserService;

@Controller
public class MainController {
	@Autowired
	PostService postService;

	@Autowired
	UserService userService;
	
	@GetMapping("/main")
	public String hello(@AuthenticationPrincipal User user,Model model) {
		List<PostResDTO> posts = postService.getAll();
		List<String> names = new ArrayList<String>();
		
		
		//Değişecek.
		for(PostResDTO p : posts) {
			System.out.println((userService.getUser(p.getUserId())).getUser());
			names.add(userService.getUser(p.getUserId()).getUser());
		}
		
		model.addAttribute("posts",posts);
		model.addAttribute("names",names);
		return "mainpage";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "admin";
	}
	
	@GetMapping("/user")
	public String user() {
		return "user";
	}

}

