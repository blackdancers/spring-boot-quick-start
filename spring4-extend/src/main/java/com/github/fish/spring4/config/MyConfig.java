package com.github.fish.spring4.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.fish.spring4.domain.User;

@Configuration
public class MyConfig {
	
	@Bean
	public User createUser() {
		return new User();
	}

}
