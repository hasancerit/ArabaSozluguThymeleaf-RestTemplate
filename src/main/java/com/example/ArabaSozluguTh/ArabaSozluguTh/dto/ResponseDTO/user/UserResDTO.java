package com.example.ArabaSozluguTh.ArabaSozluguTh.dto.ResponseDTO.user;

import java.util.HashSet;
import java.util.Set;

import com.example.ArabaSozluguTh.ArabaSozluguTh.dto.ResponseDTO.car.CarResDTO;
import com.example.ArabaSozluguTh.ArabaSozluguTh.dto.ResponseDTO.post.PostResDTO;

import lombok.Data;

@Data
public class UserResDTO {
	private String id;
	private String name;
	private String user;
	private String  pass;
	private Set<CarResDTO> cars = new HashSet<CarResDTO>();
	private Set<PostResDTO> posts = new HashSet<PostResDTO>();
	
	public void setPostsUserId() {
		for(PostResDTO p : posts) {
			p.setUserId();
		}
	}
	
	private String token;
}
