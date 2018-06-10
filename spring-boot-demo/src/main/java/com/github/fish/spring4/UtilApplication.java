package com.github.fish.spring4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.github.fish.spring4.util.DeleteLastUpdated;

/**
 * 
 * 
 *
 */
@SpringBootApplication
@ComponentScan
public class UtilApplication {

	public static void main(String[] args) {
		// 获取不同环境的配置文件的值
		SpringApplication app = new SpringApplication(DemoMutableApplication.class);
		app.setAdditionalProfiles("repo");
		ConfigurableApplicationContext context = app.run(args);
		//
		String repo = context.getEnvironment().getProperty("maven.repo");
		context.getBean(DeleteLastUpdated.class).deleteLastUpdated(repo);
		//
//		String filePath = context.getEnvironment().getProperty("clean.path");
//		context.getBean(CleanGit.class).exec(filePath);
		
		context.close();
	}
}
