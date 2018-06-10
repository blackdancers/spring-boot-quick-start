package com.github.fish.spring4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoMutableApplication {
	
	public static void main(String[] args) {
		//获取不同环境的配置文件的值
		SpringApplication app = new SpringApplication(DemoMutableApplication.class);
//		app.setAdditionalProfiles("dev");
//		app.setAdditionalProfiles("test");
		ConfigurableApplicationContext context = app.run(args);
		System.out.println(context.getEnvironment().getProperty("jdbc.url"));
		context.close();
		//还可以使用启动参数指定环境
		//--spring.profiles.active=test
	}
}
