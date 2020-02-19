package com.example.ArabaSozluguTh.ArabaSozluguTh.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.server.authorization.AuthorizationContext;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.example.ArabaSozluguTh.ArabaSozluguTh.security.filters.AuthenticationFilter;

@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter{
	@Autowired
	UserDetailsService userDetailService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	AccessDeniedHandler accessDeniedHandler;
	
	public AuthenticationFilter authenticationFilter() throws Exception {
		AuthenticationFilter filter = new AuthenticationFilter();
	    filter.setAuthenticationManager(authenticationManagerBean());
	    filter.setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/user/handlelogin","POST"));
	    /*UsernamePasswordFilter default olarak /login'e gelen istekleri karşılar.
	     * Bu kod parçası sayesinde, /user/handlelogin'e gelen istekleri karşılamasını sağlarız*/
	    return filter;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/", "/user/hello","/user/signup").permitAll() 
				.antMatchers("/admin").hasAuthority("ADMIN")
				.antMatchers("/user").hasAnyAuthority("ADMIN","USER")
				.and()
				.addFilterAt(authenticationFilter(),UsernamePasswordAuthenticationFilter.class)
			.formLogin()
				.loginPage("/user/login")
/*Sayfa LoginPage'e yönleneceği zaman buraya GET istegi at. Bunun metodunu biz yazarız ve yönlendirmek istediğimiz sayfaya yönlendiririz*/
				.loginProcessingUrl("/user/handlelogin")
 /*LoginPage'teki form, post isteğini buraya atmak zorundadır.Bu post metodunu biz yazmayız,spring sunar, yazsak bile spring ezer.*/
				.permitAll()      
				.and()
			.logout()
				.permitAll();
		 http.exceptionHandling().accessDeniedHandler(accessDeniedHandler);
	}
	
	/*Doğrulama işlemleri için, Loginden gelen bilgiler ile karşılaştırılacak User'ları nereden çekeceğimizi belirler*/
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailService).passwordEncoder(bCryptPasswordEncoder);
	}
}
