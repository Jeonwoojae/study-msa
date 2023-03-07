package com.example.msaservicecoffeeorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MsaServiceCoffeeOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsaServiceCoffeeOrderApplication.class, args);
	}

}
