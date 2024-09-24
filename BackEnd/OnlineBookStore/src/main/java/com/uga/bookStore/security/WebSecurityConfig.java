package com.uga.bookStore.security;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.uga.bookStore.service.UserService;
import com.uga.bookStore.service.UserServiceImpl;



@Configuration
@EnableMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig {

	@Autowired
	private AuthenticationEntryPointJwt unauthorizedHandler;

	@Autowired
	AuthenticationTokenFilter authTokenFilter;

	@Autowired
	UserServiceImpl userServiceImpl;

	

	@Bean
	public AuthenticationManager authenticationManager(HttpSecurity http, UserServiceImpl userServiceImpl,
			BCryptPasswordEncoder passwordEncoder) throws Exception {
		return http.getSharedObject(AuthenticationManagerBuilder.class).userDetailsService(userServiceImpl)
				.passwordEncoder(passwordEncoder).and().build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable().exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
				.authorizeHttpRequests().requestMatchers("/users/signin/**").permitAll()
				.requestMatchers("/users/register/**").permitAll()
				.requestMatchers("/verifyUser/**").permitAll()
				.requestMatchers("/users/forgotPassword/**").permitAll()
				.requestMatchers("/users/verifyUser/**").permitAll()
				.requestMatchers("/getAllShowTimings/**").permitAll()
				.requestMatchers("/getAllMovies/**").permitAll()
				.requestMatchers("/selectSeats/**").permitAll()
				.requestMatchers("/users/getBooks/**").permitAll()
				.requestMatchers("/getSeatsInShowRoom").permitAll()
				.requestMatchers("/users/filterBook/**").permitAll()
				.requestMatchers("/users/getBooks/**").permitAll()
				.requestMatchers("/admin/addBook").permitAll()
				.requestMatchers("/users/verifyForgotPasswordOTP/**").permitAll().anyRequest().authenticated().and()
				.addFilterBefore(authTokenFilter, UsernamePasswordAuthenticationFilter.class);
//		http.authenticationProvider(authenticationProvider());

//        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);

		return http.build();
	}
}