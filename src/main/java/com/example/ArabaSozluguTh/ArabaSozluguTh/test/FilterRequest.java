package com.example.ArabaSozluguTh.ArabaSozluguTh.test;

import java.io.IOException;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import ch.qos.logback.classic.Logger;


@Component
public class FilterRequest implements AccessDeniedHandler {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		System.out.println("TEST TEST");
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		Set<String> roles = authentication.getAuthorities().stream()
		     .map(r -> r.getAuthority()).collect(Collectors.toSet());
		
		for(String s : roles)
			System.out.println(s);

		  if (authentication != null) {
		      System.out.println("User: " + authentication.getName()
		        + " attempted to access the protected URL: "
		        + request.getRequestURI());
		  }

		  response.sendRedirect(request.getContextPath() + "/accessDenied");
		
	}
}
		
		