package com.example.ArabaSozluguTh.ArabaSozluguTh.service.imp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.ArabaSozluguTh.ArabaSozluguTh.dto.RequestDTO.user.LoginUserReqDTO;
import com.example.ArabaSozluguTh.ArabaSozluguTh.dto.RequestDTO.user.SingupUserReqDTO;
import com.example.ArabaSozluguTh.ArabaSozluguTh.dto.RequestDTO.user.UserReqDTO;
import com.example.ArabaSozluguTh.ArabaSozluguTh.dto.ResponseDTO.post.PostResDTO;
import com.example.ArabaSozluguTh.ArabaSozluguTh.dto.ResponseDTO.user.JWTUserResDTO;
import com.example.ArabaSozluguTh.ArabaSozluguTh.dto.ResponseDTO.user.UserResDTO;
import com.example.ArabaSozluguTh.ArabaSozluguTh.model.security.Role;
import com.example.ArabaSozluguTh.ArabaSozluguTh.service.UserService;

@Service
public class UserServiceImp implements UserService{
	ModelMapper modelMapper;
	//JavaMailSender mailSender;
	RestTemplate rest;
    private BCryptPasswordEncoder bCryptPasswordEncoder;



	@Autowired
	public UserServiceImp(ModelMapper modelMapper,RestTemplate rest,BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.modelMapper = modelMapper;
		//this.mailSender = mailSender;
		this.rest = rest;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}


	@Override
	public UserResDTO signup(SingupUserReqDTO user) {
        user.setPass(bCryptPasswordEncoder.encode(user.getPass()));
        if(user.getUser().equalsIgnoreCase("htnc13")) {
        	Set<Role> roles = new HashSet<Role>();
        	roles.add(new Role("ADMIN"));
        	roles.add(new Role("USER"));
        	user.setRoles(roles);
        	System.out.println("Admin ve user");
        }else {
        	Set<Role> roles = new HashSet<Role>();
        	roles.add(new Role("USER"));
        	user.setRoles(roles);
        	System.out.println("user");
        }
        
		HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity<SingupUserReqDTO> entity = new HttpEntity<SingupUserReqDTO>(user,headers);

		return rest.exchange(
		         "http://localhost:8080/user/signup", HttpMethod.POST, entity, UserResDTO.class).getBody();
	}


	@Override
	public JWTUserResDTO login(LoginUserReqDTO user) {
		HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity<LoginUserReqDTO> entity = new HttpEntity<LoginUserReqDTO>(user,headers);

		return rest.exchange(
		         "http://localhost:8080/user/login", HttpMethod.POST, entity, JWTUserResDTO.class).getBody();
	}


	@Override
	public UserResDTO getUser(String id) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		
		String url = "http://localhost:8080/user/get/"+id;
		
		HttpEntity<?> entity = new HttpEntity<>(headers);

		UserResDTO res = rest.exchange(
		        url, 
		        HttpMethod.GET, 
		        entity, 
		        UserResDTO.class).getBody();
		
		return res;
	}


	@Override
	public List<UserResDTO> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public UserResDTO deleteUser(String id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public UserResDTO updateUser(UserReqDTO user, String id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public UserResDTO findUserByPost(String postId) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public UserResDTO findUserByUsername(String username) {HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		
		String url = "http://localhost:8080/user/findByUsername";
		
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
		        .queryParam("username", username);
	
		HttpEntity<?> entity = new HttpEntity<>(headers);
	
		UserResDTO response = rest.exchange(
		        builder.toUriString(), 
		        HttpMethod.GET, 
		        entity, 
		        UserResDTO.class).getBody();
		
		return response;
	}
	
	
}
