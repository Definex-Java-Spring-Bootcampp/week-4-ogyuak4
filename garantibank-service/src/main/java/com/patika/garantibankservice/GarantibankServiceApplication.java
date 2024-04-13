package com.patika.garantibankservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class GarantibankServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GarantibankServiceApplication.class, args);
	}

}
