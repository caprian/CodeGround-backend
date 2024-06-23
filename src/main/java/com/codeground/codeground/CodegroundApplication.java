package com.codeground.codeground;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.codeground.codeground.dao")
public class CodegroundApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodegroundApplication.class, args);
	}

}
