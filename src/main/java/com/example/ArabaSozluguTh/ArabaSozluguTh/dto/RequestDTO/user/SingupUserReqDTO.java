package com.example.ArabaSozluguTh.ArabaSozluguTh.dto.RequestDTO.user;


import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class SingupUserReqDTO {
	
	@NotNull
	private String name;

	@NotNull
	private String user;

	@NotNull
	private String  pass;
}
