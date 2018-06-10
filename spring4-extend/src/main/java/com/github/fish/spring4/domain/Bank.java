package com.github.fish.spring4.domain;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Bank {

	private ApplicationContext applicationContext;
	
	//构造函数 必须是这样的，有局限性
	public Bank(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}
	
	public void show() {
		System.out.println("Bank : "+ applicationContext.getClass());
	}
}
