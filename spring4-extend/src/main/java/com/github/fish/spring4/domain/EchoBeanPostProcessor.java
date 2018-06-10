package com.github.fish.spring4.domain;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class EchoBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("\t-----------> Before Initialization ------------> \t" + bean.getClass());
		return bean	;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.err.println("\t-----------> After Initialization ------------> \t" + bean.getClass());
		return bean;
	}

}
