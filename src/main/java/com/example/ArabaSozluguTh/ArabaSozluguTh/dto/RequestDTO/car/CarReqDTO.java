package com.example.ArabaSozluguTh.ArabaSozluguTh.dto.RequestDTO.car;

import lombok.Data;
import javax.validation.constraints.NotNull;

@Data
public class CarReqDTO {
	@NotNull
	private String modelAdi;
	private String yakıt;
	private String vites;
	private String silindirHacmi;
	private String beygir;
	@NotNull
	private String yas;
}
