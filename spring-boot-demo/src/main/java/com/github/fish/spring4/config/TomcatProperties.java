package com.github.fish.spring4.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


/**
 * 支持获取数组和集合
 * 配置方式name[index]=value
 * @author Administrator
 *
 */
@Component
@ConfigurationProperties("ds")
public class TomcatProperties {
	
	//列表和数组
	private List<String> hosts = new ArrayList<String>();
	private String[] ports ;
	public List<String> getHosts() {
		return hosts;
	}
	public void setHosts(List<String> hosts) {
		this.hosts = hosts;
	}
	public String[] getPorts() {
		return ports;
	}
	public void setPorts(String[] ports) {
		this.ports = ports;
	}
	@Override
	public String toString() {
		return "TomcatProperties [hosts=" + hosts + ", ports=" + Arrays.toString(ports) + "]";
	}
	
	
}
