package com.regjobapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.regjobapi.config.property.RegJobApiProperty;


@SpringBootApplication
@EnableConfigurationProperties(RegJobApiProperty.class)
public class RegjobApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegjobApiApplication.class, args);
	}

}
