package com.example.chapter02;

import com.example.chapter02.domain.PriceUnit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.util.Locale;

@Slf4j
@SpringBootApplication
public class SpringBean01Application {
    public static void main(String[] args) {

        // ApplicationContext의 run()이 리턴하는 객체를 대입.
        // ApplicationContext 객체는 스프링 빈 컨테이너로 해당 클래스를 설정파일로 로딩
        // 그래서 아래에 선언한 스프링 빈을 로딩한다.
        ConfigurableApplicationContext ctxt = SpringApplication.run(SpringBean01Application.class, args);

        // 스프링 빈 객체를 defaultPriceUnit에 저장.
        // 컨테이너는 이름이 priceUnit이고 타입이 PriceUnit인 빈 객체를 리턴
        PriceUnit defaultPriceUnit = ctxt.getBean("priceUnit", PriceUnit.class);
        log.info("Price #1 : {}", defaultPriceUnit.format(BigDecimal.valueOf(10.2)));

        PriceUnit wonPriceUnit = ctxt.getBean("wonPriceUnit", PriceUnit.class);
        log.info("Price #2 : {}", wonPriceUnit.format(BigDecimal.valueOf(1000)));

        ctxt.close();
    }

    // priceUnit은 스프링 빈의 이름
    @Bean(name = "priceUnit")
    // PriceUnit는 빈의 클래스 타입
    public PriceUnit dollarPriceUnit() {
        // 리턴하는 객체는 스프링 빈 객체로 설정
        return new PriceUnit(Locale.US);
    }

    // 빈 이름을 생략하면 빈 이름은 메서드명으로 대체된다.
    @Bean
    public PriceUnit wonPriceUnit() {
        return new PriceUnit(Locale.KOREA);
    }
}
