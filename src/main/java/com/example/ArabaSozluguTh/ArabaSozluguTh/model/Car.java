package com.example.ArabaSozluguTh.ArabaSozluguTh.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(exclude = {"user","post"})
@Setter
@Getter
public class Car {
	private String id;
	
	private String modelAdi;
	private String yakıt;
	private String vites;
	private String silindirHacmi;
	
	private String beygir;
	
	private String yas;
	private User user;

	private Post post;	
}
