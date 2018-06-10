package com.github.fish.spring4.factory;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

import com.github.fish.spring4.domain.Person;


@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		// TODO Auto-generated method stub

	}

	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		//动态注入Bean
		for (int i = 0; i < 100; i++) {
			BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(Person.class);
			beanDefinitionBuilder.addPropertyValue("name", "zhangsan");
			beanDefinitionBuilder.addPropertyValue("mobilePhone", "18611999696");
			AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
			registry.registerBeanDefinition("Person"+i, beanDefinition);
		}

	}

}
