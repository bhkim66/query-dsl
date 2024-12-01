package com.bhkim.querydsl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication(scanBasePackageClasses = {BasePackage.class})
public class QueryDslApplication {

	public static void main(String[] args) {
		SpringApplication.run(QueryDslApplication.class, args);
	}

}
