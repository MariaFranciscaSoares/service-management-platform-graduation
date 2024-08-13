package br.com.piel.service.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelConfiguration {

	@Bean
	public ModelMapper getMapper() {
		return new ModelMapper();
	}

}
