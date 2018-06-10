package com.github.fish.spring4.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;



/**
 * application.properties配置文件默认的位置在classpath的resources根目录或者
 * classpath:/resources/config目录下的application.properties
 * @author Administrator
 *
 */
@Component
public class MyUserConfig {
	
	@Value("${local.port}")
	private String port;
	
	
	/**
	 * 默认必须有配置项，配置项可以为空，如果没有配置项，则必须给定默认值。
	 * Could not resolve placeholder 'tomcat.port' in value "${tomcat.port}"
	 */
	@Value("${tomcat.port:9080}")
	private String tomcatPort;
	
	
	
	
	@Autowired
	private Environment environment;
	
	public void show() {
		System.err.println("ip = "+ environment.getProperty("ip")+"\n");
		System.err.println("ip port= "+ port+"\n");
		System.err.println("tomcat port= "+ tomcatPort+"\n");
		System.err.println("name = "+ environment.getProperty("name")+"\n");
		System.err.println("app.name = "+ environment.getProperty("app.name")+"\n");
	}
	

}
