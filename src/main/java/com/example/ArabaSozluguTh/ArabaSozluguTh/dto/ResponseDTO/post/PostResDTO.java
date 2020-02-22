package com.example.ArabaSozluguTh.ArabaSozluguTh.dto.ResponseDTO.post;


import javax.validation.constraints.NotNull;

import com.example.ArabaSozluguTh.ArabaSozluguTh.dto.ResponseDTO.car.CarResDTO;
import com.example.ArabaSozluguTh.ArabaSozluguTh.dto.ResponseDTO.user.UserResDTO;
import com.example.ArabaSozluguTh.ArabaSozluguTh.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class PostResDTO {
	private String id;
	private String aciklama;
	private String fiyat;
	
	@JsonIgnore
	private User user;
	
	//?
	@JsonIgnore
	private UserResDTO userRes;
	
	private String userId;
	private CarResDTO car;
	
	public void setUserId() {	
		userId = user.getId();
	}
	
	@NotNull
	private String baslik;
	
	@NotNull
	private String tarih;
}
