package com.github.fish.spring4.extend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.github.fish.spring4.domain.Person;


public class APP {
	public static void main(String[] args) {
		//spring容器，基于注解
//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//		context.close();
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.github.fish.spring4");
//		System.out.println(context.getBean(User.class)); //根据类型
//		System.out.println(context.getBean("user")); 	 //根据名称
//		System.out.println(context.getBean("createUser"));//根据名称
//		User user = context.getBean("user",User.class);
//		context.getBean("user",User.class).show();
//		context.getBean("book",Book.class).show();
//		context.getBean("bank",Bank.class).show();
		
		context.getBeansOfType(Person.class).values().forEach(System.out::println);
		context.close();
	}

}
