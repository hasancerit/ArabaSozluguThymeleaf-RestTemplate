package com.example.ArabaSozluguTh.ArabaSozluguTh.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ldap.embedded.EmbeddedLdapProperties.Credential;
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
public class SecController {
	
	@GetMapping("/admin")
	public String admin(Model model,Principal p) {
		System.out.println(p.getName());
		return "admin";
	}
	
	@GetMapping("/user")
	public String user(Model model) {
		return "user";
	}

}

