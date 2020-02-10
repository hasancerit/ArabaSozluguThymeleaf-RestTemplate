package com.example.ArabaSozluguTh.ArabaSozluguTh.service;

import java.util.List;

import com.example.ArabaSozluguTh.ArabaSozluguTh.dto.RequestDTO.post.PostReqDTO;
import com.example.ArabaSozluguTh.ArabaSozluguTh.dto.ResponseDTO.post.PostResDTO;


public interface PostService {

	PostResDTO addPost(PostReqDTO post);

	PostResDTO getPost(String id);

	List<PostResDTO> getAll();

	PostResDTO delete(String id);

	PostResDTO update(String id, PostReqDTO post);

	List<PostResDTO> getPostsByUser(String userId);

}
