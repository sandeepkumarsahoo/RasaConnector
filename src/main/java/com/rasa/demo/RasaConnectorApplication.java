package com.rasa.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.rasa.demo")
public class RasaConnectorApplication {

	public static void main(String[] args) {
		SpringApplication.run(RasaConnectorApplication.class, args);
	}
}
