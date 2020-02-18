package com.example.ArabaSozluguTh.ArabaSozluguTh.service.imp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.ArabaSozluguTh.ArabaSozluguTh.dto.RequestDTO.user.SingupUserReqDTO;
import com.example.ArabaSozluguTh.ArabaSozluguTh.dto.ResponseDTO.user.UserResDTO;
import com.example.ArabaSozluguTh.ArabaSozluguTh.model.security.Role;

@Service
public class UserDetailServiceImp implements UserDetailsService{
	ModelMapper modelMapper;
	RestTemplate rest;

	@Autowired
	public UserDetailServiceImp(ModelMapper modelMapper,RestTemplate rest) {
		this.modelMapper = modelMapper;
		//this.mailSender = mailSender;
		this.rest = rest;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		HttpHeaders headers = new HttpHeaders();
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
		
		Set<GrantedAuthority> roles = new HashSet<>();
		for(Role r : response.getRoles()) {
			System.out.println("ROLLER");
			System.out.println(r.getRole());
			roles.add(new SimpleGrantedAuthority(r.getRole()));
		}
		        
		User user = new User(response.getUser(), response.getPass(),roles);
		return user;
	}

}
