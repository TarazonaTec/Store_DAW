package com.StoreOnline;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

//anotación para habilitar la seguridad
@EnableWebSecurity
@Configuration
public class SecurityConfig {
	
	
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public  SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		

		http.csrf(csrf->csrf.disable())
		.authorizeHttpRequests((auth)->{
			
			auth.antMatchers("/mantenimiento").hasRole("Administrador");			
			auth.anyRequest().authenticated();})
		
		.formLogin(form-> form.loginPage("/login")
		.permitAll().defaultSuccessUrl("/intranet"));
		
		return http.build();
	/*

		 http
         .authorizeRequests()
             .anyRequest().authenticated()
             .and()
         .formLogin()
             .loginPage("/login");
		*/
		
	}
	
	/*
	
	
	
	
	protected void configure(HttpSecurity http) throws Exception {
			http.authorizeHttpRequests().antMatchers(
					"/index**",
					"/js/**",
					"/css/**",
					"/img/**",
					"/alertifyjs/**",
					"/resources/**",
					"/scss/**",
					"/vendor/**").permitAll()
			.anyRequest().authenticated()
			.and()
			.formLogin()
			.loginPage("/login")
			.permitAll()
			.and()
			.logout()
			.invalidateHttpSession(true)
			.clearAuthentication(true)
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.logoutSuccessUrl("/login?logout")
			.permitAll();
	 }
	
	*/

	
	/*
	@Bean
	public UserDetailsService userDetailsService(BCryptPasswordEncoder encoder) {
		//crear objeto de la InMemoryUserDetailsManager
		InMemoryUserDetailsManager manager=new InMemoryUserDetailsManager();
		manager.createUser(User.withUsername("luis").password(encoder.encode("123")).roles("USER").build());
		manager.createUser(User.withUsername("carlos").password(encoder.encode("456")).roles("ADMIN").build());
		
		return manager;
	}
	
	*/
	
	
}
