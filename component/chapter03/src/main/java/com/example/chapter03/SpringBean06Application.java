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

    @Bean(initMethod = "init", destroyMethod = "clear")
    public LifeCycleComponent lifecycleComponent() {
        return new LifeCycleComponent();
    }

    @Bean
    public BeanPostProcessor beanPostProcessor() {
        return new PrintableBeanPostProcessor();
    }
}
