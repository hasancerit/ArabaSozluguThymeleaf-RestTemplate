package com.example.ArabaSozluguTh.ArabaSozluguTh.model;


import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(exclude = {"user","car"})
@Setter
@Getter
public class Post {
	private String id;
	
	private String aciklama;
	private String fiyat;
	@JsonManagedReference
	private User user;
	private Car car;
	private String baslik;
	private String tarih;
}
