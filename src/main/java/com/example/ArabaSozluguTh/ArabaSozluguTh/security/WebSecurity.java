package com.example.ArabaSozluguTh.ArabaSozluguTh.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter{
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/", "/user/hello","/user/signup").permitAll() 
				.antMatchers("/admin").hasRole("ADMIN")
				.antMatchers("/user").hasAnyRole("ADMIN","USER")
				.and()
				//.addFilterAt(new CustomUsernamePasswordAuthenticationFilter(authenticationManager()),UsernamePasswordAuthenticationFilter.class)
			.formLogin()
			//.loginProcessingUrl("/login")
			.loginPage("/user/login")
/*Sayfa LoginPage'e yönleneceği zaman buraya GET istegi at. Bunun metodunu biz yazarız ve yönlendirmek istediğimiz sayfaya yönlendiririz 
 *Aynı zamanda LoginPage'teki form, post isteğini buraya atmak zorundadır. Bu post metodunu biz yazmayız, yazsak bile spring ezer.*/
				.permitAll()      
				.and()
			.logout()
				.permitAll();
	}
	
	@Bean
	@Override
	public UserDetailsService userDetailsService() {
		UserDetails user =
			 User.withDefaultPasswordEncoder()
				.username("admin")
				.password("password")
				.roles("ADMIN")
				.build();
		
		UserDetails user2 =
				 User.withDefaultPasswordEncoder()
					.username("user")
					.password("password")
					.roles("USER")
					.build();
		
		List<UserDetails> users = new ArrayList<UserDetails>();
		users.add(user);
		users.add(user2);
		return new InMemoryUserDetailsManager(users);
	}
}
