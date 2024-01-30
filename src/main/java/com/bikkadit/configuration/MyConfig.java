package com.bikkadit.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class MyConfig {

	// Component , Service ,Controller ,Repository ,RestController
	// Bean
	
	// Security 
	// Logger , validation and  validation exception

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();

	}
   
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
