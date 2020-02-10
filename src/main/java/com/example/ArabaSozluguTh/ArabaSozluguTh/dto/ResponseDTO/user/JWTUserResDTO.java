package com.example.ArabaSozluguTh.ArabaSozluguTh.dto.ResponseDTO.user;


import lombok.Data;

@Data
public class JWTUserResDTO {
	private String id;
	private String name;
	private String user;
	private String  pass;
	private String token;
}
