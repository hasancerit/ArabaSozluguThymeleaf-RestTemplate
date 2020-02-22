package com.example.ArabaSozluguTh.ArabaSozluguTh.service.imp;

import java.util.ArrayList;
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
import org.springframework.web.util.UriComponentsBuilder;

import com.example.ArabaSozluguTh.ArabaSozluguTh.dto.RequestDTO.post.PostReqDTO;
import com.example.ArabaSozluguTh.ArabaSozluguTh.dto.RequestDTO.user.LoginUserReqDTO;
import com.example.ArabaSozluguTh.ArabaSozluguTh.dto.ResponseDTO.post.PostResDTO;
import com.example.ArabaSozluguTh.ArabaSozluguTh.dto.ResponseDTO.user.JWTUserResDTO;
import com.example.ArabaSozluguTh.ArabaSozluguTh.dto.ResponseDTO.user.UserResDTO;
import com.example.ArabaSozluguTh.ArabaSozluguTh.service.PostService;

@Service
public class PostServiceImp implements PostService{
	ModelMapper modelMapper;
	RestTemplate rest;

	
	@Autowired
	public PostServiceImp(ModelMapper modelMapper,RestTemplate rest) {
		this.modelMapper = modelMapper;
		this.rest = rest;
	}

	@Override
	public PostResDTO addPost(PostReqDTO post) {
		HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity<PostReqDTO> entity = new HttpEntity<PostReqDTO>(post,headers);

		return rest.exchange(
		         "http://localhost:8080/post/addPost", HttpMethod.POST, entity, PostResDTO.class).getBody();
	}

	@Override
	public PostResDTO getPost(String id) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		
		String url = "http://localhost:8080/post/get/"+id;
		
		HttpEntity<?> entity = new HttpEntity<>(headers);

		PostResDTO res= rest.exchange(
		        url, 
		        HttpMethod.GET, 
		        entity, 
		        PostResDTO.class).getBody();
		return res;
	}

	@Override
	public List<PostResDTO> getAll() {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		
		String url = "http://localhost:8080/post/getAll";
		
		HttpEntity<?> entity = new HttpEntity<>(headers);

		PostResDTO[] resArr = rest.exchange(
		        url, 
		        HttpMethod.GET, 
		        entity, 
		        PostResDTO[].class).getBody();
		List<PostResDTO> res = Arrays.asList(resArr);
		return res;
	}

	@Override
	public PostResDTO delete(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PostResDTO update(String id, PostReqDTO post) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostResDTO> getPostsByUser(String userId) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
