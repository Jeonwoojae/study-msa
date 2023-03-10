package com.example.chapter03.config;

import com.example.chapter03.domain.format.DateFormatter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//  자바 설정 클래스 선언, 빈 정의할 수 있음
public class ServerConfig {

    @Bean
    public String datePattern() {
        return "yyyy-MM-dd'T'HH:mm:ss.XXX";
    }

    @Bean
//    String 객체에 의존성이 있다.
//    메소드를 사용하면 dataPattern 이름의 스프링 빈 객체를 컨테이너가 주입한다.(스프링 빈 참조)
    public DateFormatter defaultDateFormatter() {
        return new DateFormatter(datePattern());
    }
}
