package com.example.ArabaSozluguTh.ArabaSozluguTh;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ArabaSozluguThApplication {

		public static void main(String[] args) {
			SpringApplication.run(ArabaSozluguThApplication.class, args);
		}

	   @Bean
	   public RestTemplate getRestTemplate() {
	      return new RestTemplate();
	   }
	   
	   @Bean
	    public ModelMapper getModelMapper() {
	        ModelMapper modelMapper = new ModelMapper();
	        modelMapper.getConfiguration()
	                .setMatchingStrategy(MatchingStrategies.STRICT);
	        return modelMapper;
	    }

}
