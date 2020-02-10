package com.example.ArabaSozluguTh.ArabaSozluguTh.service.imp;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ArabaSozluguTh.ArabaSozluguTh.dto.RequestDTO.post.PostReqDTO;
import com.example.ArabaSozluguTh.ArabaSozluguTh.dto.ResponseDTO.post.PostResDTO;
import com.example.ArabaSozluguTh.ArabaSozluguTh.service.PostService;

@Service
public class PostServiceImp implements PostService{
	ModelMapper modelMapper;
	
	@Autowired
	public PostServiceImp(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

	@Override
	public PostResDTO addPost(PostReqDTO post) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PostResDTO getPost(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostResDTO> getAll() {
		// TODO Auto-generated method stub
		return null;
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
