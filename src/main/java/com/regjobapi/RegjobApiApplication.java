package com.regjobapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;

import com.regjobapi.config.property.RegJobApiProperty;


@SpringBootApplication
@EnableConfigurationProperties(RegJobApiProperty.class)
public class RegjobApiApplication {
	private static ApplicationContext APPLICATION_CONTEXT;
	public static void main(String[] args) {
		APPLICATION_CONTEXT =	SpringApplication.run(RegjobApiApplication.class, args);
	}
	
	

	public static <T> T getBean(Class<T> type) {
		return APPLICATION_CONTEXT.getBean(type);
	}

}
