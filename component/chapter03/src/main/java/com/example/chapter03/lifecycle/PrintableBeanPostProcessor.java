package com.example.chapter03.lifecycle;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

@Slf4j
public class PrintableBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        // BeanPostProcessor는 모든 스프링 빈에 적용되므로 가독성을 위해 특정 스프링 빈 이름인 경우만 출력하도록 함 아래도 동일
        if ("lifecycleComponent".equals(beanName))
            log.error("Called postProcessBeforeInitialization() for : {}", beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if ("lifecycleComponent".equals(beanName))
            log.error("Called postProcessAfterInitialization() for : {}", beanName);
        return bean;
    }
}
