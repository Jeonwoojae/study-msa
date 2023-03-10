package com.example.chapter03;

import com.example.chapter03.lifecycle.LifeCycleComponent;
import com.example.chapter03.lifecycle.PrintableBeanPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBean06Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctxt = SpringApplication.run(SpringBean06Application.class);
        ctxt.close();
    }

    /**
     * LifeCycleComponent 클래스의 init 메서드를 설정한다. 그럼 스프링 빈 생성 후 실행된다.
     * detroy는 clear메서드 이름을 설정하며 애플리케이션이 종료되기 전 실행된다.
     */
    @Bean(initMethod = "init", destroyMethod = "clear")
    public LifeCycleComponent lifecycleComponent() {
        return new LifeCycleComponent();
    }

    // 스프링 빈으로 사용하기 위해 @Bean 정의
    @Bean
    public BeanPostProcessor beanPostProcessor() {
        return new PrintableBeanPostProcessor();
    }
}
