package br.com.magalu.desafios.communication.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = "br.com.magalu.desafios")
@EntityScan("br.com.magalu.desafios.communication.domain.entity")
public class WebAPIApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebAPIApplication.class, args);
	}

}
