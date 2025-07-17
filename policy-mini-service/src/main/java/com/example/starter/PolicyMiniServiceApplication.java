package com.example.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = {"com.example"})
@EntityScan(basePackages = {"com.example"})
@EnableJpaRepositories(basePackages = {"com.example"})
@EnableFeignClients(basePackages = {"com.example.feign"})

@SpringBootApplication
public class PolicyMiniServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PolicyMiniServiceApplication.class, args);
	}

}
