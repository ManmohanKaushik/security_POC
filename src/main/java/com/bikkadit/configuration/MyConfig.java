package com.bikkadit.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

	// Component , Service ,Controller ,Repository ,RestController
	// Bean

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();

	}

}
