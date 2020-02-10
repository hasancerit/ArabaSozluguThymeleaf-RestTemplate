package com.example.ArabaSozluguTh.ArabaSozluguTh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.ArabaSozluguTh.ArabaSozluguTh.dto.RequestDTO.user.SingupUserReqDTO;
import com.example.ArabaSozluguTh.ArabaSozluguTh.dto.ResponseDTO.user.UserResDTO;
import com.example.ArabaSozluguTh.ArabaSozluguTh.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("a")
	public String am() {
		return "A";
	}
	
	@GetMapping("/test")
	public ResponseEntity<UserResDTO> signUp(){
		System.out.println("USER TEST");
		SingupUserReqDTO user = new SingupUserReqDTO();
		user.setName("Hasan");
		user.setPass("123");
		user.setUser("htnc13");
		return new ResponseEntity<UserResDTO>(userService.signup(user),HttpStatus.OK);
	}

/*
	@PostMapping("/signup")
	public ResponseEntity<UserResDTO> signUp( @Valid @RequestBody SingupUserReqDTO user){
		return new ResponseEntity<UserResDTO>(userService.signup(user),HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity<JWTUserResDTO> login(@Valid @RequestBody LoginUserReqDTO user){
		return new ResponseEntity<JWTUserResDTO>(userService.login(user),HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<UserResDTO> getUser(@PathVariable String id){
		return new ResponseEntity<UserResDTO>(userService.getUser(id),HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<UserResDTO>> getAll(){
		return new ResponseEntity<List<UserResDTO>> (userService.getAllUsers(),HttpStatus.OK);
	}
	
	@GetMapping("/delete/{id}")
	public ResponseEntity<UserResDTO> deleteUser(@PathVariable String id){
		return new ResponseEntity<UserResDTO> (userService.deleteUser(id),HttpStatus.OK);
	}
	
	@PostMapping("/update/{id}")
	public ResponseEntity<UserResDTO> updateUser(@RequestBody UserReqDTO user,@PathVariable String id){
		return new ResponseEntity<UserResDTO> (userService.updateUser(user, id),HttpStatus.OK);
	}
	
	@GetMapping("/findByPost/{postId}")
	public ResponseEntity<UserResDTO> findUserById(@PathVariable String postId){
		return new ResponseEntity<UserResDTO> (userService.findUserByPost(postId),HttpStatus.OK);
	}
	*/
}

