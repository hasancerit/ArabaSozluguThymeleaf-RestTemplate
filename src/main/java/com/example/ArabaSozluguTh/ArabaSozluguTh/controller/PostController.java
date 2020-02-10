package com.example.ArabaSozluguTh.ArabaSozluguTh.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.example.ArabaSozluguTh.ArabaSozluguTh.dto.RequestDTO.post.PostReqDTO;
import com.example.ArabaSozluguTh.ArabaSozluguTh.dto.ResponseDTO.post.PostResDTO;
import com.example.ArabaSozluguTh.ArabaSozluguTh.service.PostService;

@Controller
@RequestMapping("/post")
public class PostController {
	@Autowired
	PostService postService;
	
	@PostMapping("addPost")
	public ResponseEntity<PostResDTO> addPost(@Valid @RequestBody PostReqDTO post){
		return new ResponseEntity<PostResDTO>(postService.addPost(post),HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<PostResDTO> getPost(@PathVariable String id){
		return new ResponseEntity<PostResDTO>(postService.getPost(id),HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<PostResDTO>> getAll(){
		return new ResponseEntity<List<PostResDTO>>(postService.getAll(),HttpStatus.OK);
	}
	
	@GetMapping("/delete/{id}")
	public ResponseEntity<PostResDTO> getAll(@PathVariable String id){
		return new ResponseEntity<PostResDTO>(postService.delete(id),HttpStatus.OK);
	}
	
	@GetMapping("/update/{id}")
	public ResponseEntity<PostResDTO> getAll(@PathVariable String id,@RequestBody PostReqDTO post){
		return new ResponseEntity<PostResDTO>(postService.update(id,post),HttpStatus.OK);
	}
	
	@GetMapping("{userId}/getposts")
	public ResponseEntity<List<PostResDTO>> getPostByUser(@PathVariable String userId){
		return new ResponseEntity<List<PostResDTO>>(postService.getPostsByUser(userId),HttpStatus.OK);
	}
	
}
