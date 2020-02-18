package com.example.ArabaSozluguTh.ArabaSozluguTh.dto.RequestDTO.user;


import java.util.Set;

import javax.validation.constraints.NotNull;

import com.example.ArabaSozluguTh.ArabaSozluguTh.model.security.Role;

import lombok.Data;

@Data
public class SingupUserReqDTO {
	
	@NotNull
	private String name;

	@NotNull
	private String user;

	@NotNull
	private String  pass;
	
	private Set<Role> roles;
}
