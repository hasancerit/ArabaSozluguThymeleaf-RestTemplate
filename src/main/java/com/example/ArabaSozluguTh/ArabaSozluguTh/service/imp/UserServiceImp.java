package com.example.ArabaSozluguTh.ArabaSozluguTh.service.imp;

import java.util.Arrays;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.ArabaSozluguTh.ArabaSozluguTh.dto.RequestDTO.user.LoginUserReqDTO;
import com.example.ArabaSozluguTh.ArabaSozluguTh.dto.RequestDTO.user.SingupUserReqDTO;
import com.example.ArabaSozluguTh.ArabaSozluguTh.dto.RequestDTO.user.UserReqDTO;
import com.example.ArabaSozluguTh.ArabaSozluguTh.dto.ResponseDTO.user.JWTUserResDTO;
import com.example.ArabaSozluguTh.ArabaSozluguTh.dto.ResponseDTO.user.UserResDTO;
import com.example.ArabaSozluguTh.ArabaSozluguTh.service.UserService;

@Service
public class UserServiceImp implements UserService{
	ModelMapper modelMapper;
	//JavaMailSender mailSender;
	RestTemplate rest;

	@Autowired
	public UserServiceImp(ModelMapper modelMapper,RestTemplate rest) {
		this.modelMapper = modelMapper;
		//this.mailSender = mailSender;
		this.rest = rest;
	}


	@Override
	public UserResDTO signup(SingupUserReqDTO user) {
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
		// TODO Auto-generated method stub
		return null;
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
	
	
}
