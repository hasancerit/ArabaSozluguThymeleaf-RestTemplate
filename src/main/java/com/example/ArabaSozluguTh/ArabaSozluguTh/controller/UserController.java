package com.example.ArabaSozluguTh.ArabaSozluguTh.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ArabaSozluguTh.ArabaSozluguTh.dto.RequestDTO.user.LoginUserReqDTO;
import com.example.ArabaSozluguTh.ArabaSozluguTh.dto.RequestDTO.user.SingupUserReqDTO;
import com.example.ArabaSozluguTh.ArabaSozluguTh.dto.ResponseDTO.user.JWTUserResDTO;
import com.example.ArabaSozluguTh.ArabaSozluguTh.dto.ResponseDTO.user.UserResDTO;
import com.example.ArabaSozluguTh.ArabaSozluguTh.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/signup")
	public String signup(Model model) {
		System.out.println("GET SİNGUP");
		model.addAttribute("user",new SingupUserReqDTO());
		return "user/signup";
	}
	
	@PostMapping("/signup")
	public String signUp(@Valid @ModelAttribute SingupUserReqDTO user,Model model){
		UserResDTO retUser = userService.signup(user);

		LoginUserReqDTO userNew = new LoginUserReqDTO();
		userNew.setUser(user.getUser());
		
		model.addAttribute("user",userNew);
		return "user/login";
	}
	
	
	@GetMapping("/login")
	public String login(Model model) {
		LoginUserReqDTO userNew = new LoginUserReqDTO();
		model.addAttribute("user",userNew);
		return "user/login";
	}
	
	@PostMapping("/login")
	public String logIn(@Valid @ModelAttribute LoginUserReqDTO user,Model model){
		System.out.println("Login Post");
		JWTUserResDTO retUser = userService.login(user);
		model.addAttribute("user",retUser);
		return "user/giris";
	}
	
/*	@GetMapping("/testAddUser")
	public ResponseEntity<UserResDTO> signUp(){
		System.out.println("USER TEST");
		SingupUserReqDTO user = new SingupUserReqDTO();
		user.setName("Hasan");
		user.setPass("123");
		user.setUser("htnc13");
		return new ResponseEntity<UserResDTO>(userService.signup(user),HttpStatus.OK);
	}
	
	@GetMapping("/testLogin")
	public ResponseEntity<JWTUserResDTO> login(){
		LoginUserReqDTO user = new LoginUserReqDTO();
		user.setUser("htnc13");
		user.setPass("123");
		return new ResponseEntity<JWTUserResDTO>(userService.login(user),HttpStatus.OK);
	}
*/

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

