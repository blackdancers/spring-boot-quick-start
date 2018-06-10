package com.github.fish.spring4.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportSelector implements ImportSelector {

	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		//这里可以获取注解信息，然后根据信息去动态返回需要被spring容器管理的bean
		System.err.println(importingClassMetadata.getAllAnnotationAttributes(EnableLog.class.getName()));
		
		return new String[] {"com.github.fish.spring4.domain.User"};
	}

}
