package com.github.fish.spring4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.ConfigurableEnvironment;

import com.github.fish.spring4.config.MyUserConfig;
import com.github.fish.spring4.config.TomcatProperties;

@SpringBootApplication
public class DemoApplication {

	@Bean
	public Runnable createRunnable() {
		return () -> {System.err.println("spring boot is running ..");};
	}
	
	
	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(DemoApplication.class, args);
		//获取配置文件的值
		ConfigurableEnvironment environment = applicationContext.getEnvironment();
		System.err.println(environment.getProperty("jdbc.username"));
		System.err.println(environment.getProperty("jdbc.password"));
//		applicationContext.getBean(Runnable.class).run();
		applicationContext.getBean(MyUserConfig.class).show();
		System.out.println(applicationContext.getBean(TomcatProperties.class));
		
		System.err.println("=========================");
		//用户自定义属性值
		System.err.println(environment.getProperty("spring-boot.name"));
		
		
		
//		applicationContext.close();
	}
}
