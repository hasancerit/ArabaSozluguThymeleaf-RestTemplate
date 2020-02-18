package com.example.ArabaSozluguTh.ArabaSozluguTh.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter{
	@Autowired
	UserDetailsService userDetailService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	AccessDeniedHandler accessDeniedHandler;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/", "/user/hello","/user/signup").permitAll() 
				.antMatchers("/admin").hasAuthority("ADMIN")
				.antMatchers("/user").hasAnyAuthority("ADMIN","USER")
				.and()
			.formLogin()
			.loginPage("/user/login")
/*Sayfa LoginPage'e yönleneceği zaman buraya GET istegi at. Bunun metodunu biz yazarız ve yönlendirmek istediğimiz sayfaya yönlendiririz 
 *Aynı zamanda LoginPage'teki form, post isteğini buraya atmak zorundadır. Bu post metodunu biz yazmayız, yazsak bile spring ezer.*/
				.permitAll()      
				.and()
			.logout()
				.permitAll();
		 http.exceptionHandling().accessDeniedHandler(accessDeniedHandler);
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailService).passwordEncoder(bCryptPasswordEncoder);
	}
}
