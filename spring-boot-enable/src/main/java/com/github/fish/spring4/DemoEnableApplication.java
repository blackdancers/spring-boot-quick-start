package com.github.fish.spring4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

import com.github.fish.spring4.domain.Person;
import com.github.fish.spring4.domain.User;


//@SpringBootApplication
//@EnableConfigurationProperties //START ERROR

//@EnableAsync	//启用异步注解,一般与注解@Async一起使用
@EnableAutoConfiguration
//@ComponentScan
@Import({User.class,Person.class})
public class DemoEnableApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DemoEnableApplication.class, args);
		//System.err.println(context.getBean(TomcatProperties.class));
		context.getBean(User.class).run();
		context.close();
	}
}
