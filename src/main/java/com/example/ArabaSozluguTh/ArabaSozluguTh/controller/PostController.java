package com.example.ArabaSozluguTh.ArabaSozluguTh.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.ArabaSozluguTh.ArabaSozluguTh.dto.RequestDTO.car.CarReqDTO;
import com.example.ArabaSozluguTh.ArabaSozluguTh.dto.RequestDTO.post.PostReqDTO;
import com.example.ArabaSozluguTh.ArabaSozluguTh.dto.ResponseDTO.post.PostResDTO;
import com.example.ArabaSozluguTh.ArabaSozluguTh.service.PostService;
import com.example.ArabaSozluguTh.ArabaSozluguTh.service.UserService;

@Controller
@RequestMapping("/post")
public class PostController {
	@Autowired
	PostService postService;

	@Autowired
	UserService userService;
	
	@GetMapping("add")
	public String addPost(@AuthenticationPrincipal User user,Model model){
		PostReqDTO post = new PostReqDTO();
		post.setTarih(new Date().toString());
		post.setUserId(userService.findUserByUsername(user.getUsername()).getId());
		post.setCar(new CarReqDTO());
		model.addAttribute("post",post);
		return "post/addpostform";
	}
	
	@PostMapping("add")
	public String addPost(@Valid @ModelAttribute("post") PostReqDTO post){
		postService.addPost(post);
		return "redirect:/main";
	}
	
	@GetMapping("get/{id}")
	public String getPost(@PathVariable String id,Model model){
		PostResDTO post = postService.getPost(id);
		post.setUserRes(userService.getUser(post.getUserId()));
		model.addAttribute("post",post);
		return "post/post";
	}
}
