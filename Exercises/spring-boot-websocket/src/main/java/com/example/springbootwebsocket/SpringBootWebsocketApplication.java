package com.example.springbootwebsocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class SpringBootWebsocketApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebsocketApplication.class, args);
	}

}
