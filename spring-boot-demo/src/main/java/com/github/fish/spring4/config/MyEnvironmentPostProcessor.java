package com.github.fish.spring4.config;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.stereotype.Component;

@Component
public class MyEnvironmentPostProcessor implements EnvironmentPostProcessor {

	@Override
	public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
		try (InputStream input = new FileInputStream("D:\\Documents\\tmp\\spring-boot.properties")) {
			Properties source = new Properties();
			source.load(input);
			PropertiesPropertySource propertySource = new PropertiesPropertySource("my", source);
			environment.getPropertySources().addLast(propertySource);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
