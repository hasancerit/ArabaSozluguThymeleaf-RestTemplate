package com.example.ArabaSozluguTh.ArabaSozluguTh.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


import lombok.Data;

public class CustomUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	private AuthenticationManager authenticationManager;

    public CustomUsernamePasswordAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res)
			throws AuthenticationException {

			System.out.println("Attemp");
			LoginRequest creds = new LoginRequest();
			creds.setUsername(req.getParameter("username")+"as");
			creds.setPassword(req.getParameter("password"));
			
			System.out.println("Test");
        	System.out.println(creds.getUsername()+" "+creds.getPassword());
        	
        	//UserServiceImp'deki LoadBByUserName methodu çağırıldı
            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            creds.getUsername(),
                            creds.getPassword())
            );
       
	}
	
	
	@Data
	private static class LoginRequest {

		String username;
		String password;

	}
}
