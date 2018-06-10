package com.github.fish.spring4.config;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import com.github.fish.spring4.domain.Person;
import com.github.fish.spring4.domain.User;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		System.err.println(importingClassMetadata.getAnnotationAttributes(EnableLog.class.getName()));
		
		BeanDefinitionBuilder userBuilder = BeanDefinitionBuilder.rootBeanDefinition(User.class);
		BeanDefinition beanDefinition = userBuilder.getBeanDefinition();
		registry.registerBeanDefinition("user", beanDefinition );
		BeanDefinitionBuilder personBuilder = BeanDefinitionBuilder.rootBeanDefinition(Person.class);
		registry.registerBeanDefinition("person", personBuilder.getBeanDefinition() );
	}

}
