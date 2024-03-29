package com.pravin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.pravin.*")
@ComponentScan(basePackages = { "com.pravin.*" })
@EntityScan("com.pravin.*")   
public class IhisDbManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(IhisDbManagementApplication.class, args);
	}

}
