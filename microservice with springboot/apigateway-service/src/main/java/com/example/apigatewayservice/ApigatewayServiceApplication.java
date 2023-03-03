package com.example.apigatewayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.trace.http.HttpTraceRepository;
import org.springframework.boot.actuate.trace.http.InMemoryHttpTraceRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApigatewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApigatewayServiceApplication.class, args);
	}

//	각 서비스가 호출되는 상태를 보여주는 actiator/httptrace를 위해 구현
	@Bean
	public HttpTraceRepository httpTraceRepository(){
		return new InMemoryHttpTraceRepository();
	}
}
