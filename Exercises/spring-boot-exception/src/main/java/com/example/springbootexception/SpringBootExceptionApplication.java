package com.example.springbootexception;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class SpringBootExceptionApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootExceptionApplication.class, args);
	}

}
