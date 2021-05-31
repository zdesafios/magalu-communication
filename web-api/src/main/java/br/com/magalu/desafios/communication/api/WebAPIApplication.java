package br.com.magalu.desafios.communication.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = "br.com.magalu.desafios")
public class WebAPIApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebAPIApplication.class, args);
	}

}
