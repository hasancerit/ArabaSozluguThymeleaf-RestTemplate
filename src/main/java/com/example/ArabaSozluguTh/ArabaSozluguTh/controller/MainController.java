package com.example.ArabaSozluguTh.ArabaSozluguTh.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ldap.embedded.EmbeddedLdapProperties.Credential;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.ArabaSozluguTh.ArabaSozluguTh.dto.ResponseDTO.post.PostResDTO;
import com.example.ArabaSozluguTh.ArabaSozluguTh.dto.ResponseDTO.user.UserResDTO;
import com.example.ArabaSozluguTh.ArabaSozluguTh.model.Post;
import com.example.ArabaSozluguTh.ArabaSozluguTh.model.User;
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
		
		
		//Değişecek.
		for(PostResDTO p : posts) {
			System.out.println(p.getId());
			UserResDTO userRes = userService.getUser(p.getUserId());
			p.setUserRes(userRes);
		}
		
		model.addAttribute("posts",posts);
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
	
	
	@GetMapping("/profile")
	public String profile(Model model,Principal p) {
		UserResDTO user = userService.findUserByUsername(p.getName());
		
		for(PostResDTO post : user.getPosts()) {
			post.setUserRes(user);
		}
		model.addAttribute("user",user);
		model.addAttribute("posts",user.getPosts());

		return "user/selfprofile";
	}

}

