package com.lucasmurilo.desafiozup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DesafiozupApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafiozupApplication.class, args);
	}

}
