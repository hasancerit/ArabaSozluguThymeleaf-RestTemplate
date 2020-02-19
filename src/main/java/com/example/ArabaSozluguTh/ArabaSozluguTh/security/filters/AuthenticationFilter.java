package com.example.ArabaSozluguTh.ArabaSozluguTh.security.filters;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter{
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		System.out.println("Attemp Auth");
		return getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(request.getParameter("username"),request.getParameter("password")));
		//return getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(request.getParameter("username")+"FilterEk",request.getParameter("password")+"filterEk"));

	}
	
	/*configure(HttpSecurity http) ayarlarında;
	 * 1-).authorizeRequests()
				.antMatchers("/", "/user/hello","/user/signup").permitAll() 
		vs. ile hangi urlleri koruyacağımızı ayarlarız.
		2-).loginPage("/user/login") ile login sayfasının, /user/loginden dönen sayfa olacağına, login işlemlerinde bu url'e istek atılacağını söyleriz
		3-).loginProcessingUrl("/user/handlelogin") ile loginformdan gelen bilgiler ile /user/handlelogin urlinin ilgileneceği söyleriz. Formumuz bu url'e istek atmalıdır
		
		
		configure(AuthenticationManagerBuilder auth) ayarlarında;
		formloginden dönen username password ile hangi bilgilerin eşleşeceğini ayarlarız. (UserDetailService ile DB'ye bağlayabilir veya gömülü DB kullanabiliriz.)
	 */
	
	/*
	 * Bir login işlemi gerçekleştiğinde;
	 * Form /user/handlelogin'e istek atar.
	 * Bu metod gerekli işlemleri yapar;
	 * 		formdan gelen username passwordu çeker
	 * 		username'e göre User'ı çeker. configure(AuthenticationManagerBuilder auth) kısmında belirlediğimiz koda göre.
	 * 		karşılaştırmayı yapar
	 * 		başarılı ise istenilen sayfaya, başarısız ise user/login'e tekrar yönlendirir(authenticate)
	 */
	
	/*
	 * UsernamePasswordAuthenticationFilter ile /user/handlelogin'in "formdan gelen username passwordu çeker" kısmına müdahele ederiz.
	 * Yani formdan gelen username, password bilgisinin alınmasını custom olarak yaparız.
	 * Örneğin yukarıdaki yorum satırını açarsak;
	 * 		form'dan gelen username ve password'u çeker, ve onlara "FilterEk" ekleriz. (Örneğin htnc13 ve 123 geldi. Artık o htnc13FilterEk ve 123FilterEk olur)
	 * 		artık username'e göre User çekilirken bu ek ile birlikte çekilir ve diğer adımlar devam eder.
	 * 
	 * Bu Filter'ın amacına örnek: login olurken kullanıcıdan daha fazla bilgi vs istemek ve kontrolu ona göre yapamak için kullanılır
	 * Doğrulama kısmına etki ettiği için AuthencitionFilter'dır
	 */
}
