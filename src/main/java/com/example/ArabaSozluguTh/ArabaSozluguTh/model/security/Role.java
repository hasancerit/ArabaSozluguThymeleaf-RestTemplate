package com.example.ArabaSozluguTh.ArabaSozluguTh.model.security;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class Role {
	private int role_id;
	private String role;
	
	public Role(String role){
		this.role = role;
	}
}