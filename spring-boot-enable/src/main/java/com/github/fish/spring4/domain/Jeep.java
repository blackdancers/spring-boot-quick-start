package com.github.fish.spring4.domain;

import java.util.concurrent.TimeUnit;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class Jeep implements Runnable {

	@Override
	@Async	//异步执行方法注解
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				System.err.println("\n------------> "+i+"\n");
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}

}
