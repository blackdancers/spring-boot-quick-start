package com.github.fish.spring4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.github.fish.spring4.config.EnableLog;
import com.github.fish.spring4.domain.User;

@SpringBootApplication
//@Import({ MyImportSelector.class })
@EnableLog(update=true)
public class ImportSelectorApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(ImportSelectorApplication.class, args);
		context.getBean(User.class).run();
		System.out.println(context.getBean("person"));
		context.close();
	}
}
