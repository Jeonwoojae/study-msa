package com.example.chapter03.lifecycle;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * 라이프 클래스는 InitializingBean 인터페이스를 구현하고 있으며 추상 메서드를 구현한다.
 * 이것은 스프링 빈 생성 후 실행되며 DisposalbleBean 인터페이스를 구현하여 destroy 추상 메소드를 구현해 어플리케이션이 종료되기 전 실행된다.
 */
@Slf4j
public class LifeCycleComponent implements InitializingBean, DisposableBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        log.error("afterPropertiesSet from InitializingBean");
    }

    @Override
    public void destroy() throws Exception {
        log.error("destroy from DisposableBean");
    }

    public void init() {
        log.error("customized init method");
    }

    public void clear() {
        log.error("customized destroy method");
    }
}
