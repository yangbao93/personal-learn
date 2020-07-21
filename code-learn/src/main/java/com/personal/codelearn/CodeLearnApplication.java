package com.personal.codelearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.personal.codelearn.*"})
public class CodeLearnApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodeLearnApplication.class, args);
	}

}
