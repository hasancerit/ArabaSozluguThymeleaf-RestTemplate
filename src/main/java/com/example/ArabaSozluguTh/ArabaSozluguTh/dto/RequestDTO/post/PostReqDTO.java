package com.example.ArabaSozluguTh.ArabaSozluguTh.dto.RequestDTO.post;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.example.ArabaSozluguTh.ArabaSozluguTh.dto.RequestDTO.car.CarReqDTO;

import lombok.Data;

@Data
public class PostReqDTO {

	@NotNull
	private String userId;
	
	@Valid
	@NotNull
	private CarReqDTO car;
	
	@NotNull
	private String aciklama;
	
	@NotNull
	private String fiyat;
	
	@NotNull
	private String baslik;
	
	@NotNull
	private String tarih;
}
