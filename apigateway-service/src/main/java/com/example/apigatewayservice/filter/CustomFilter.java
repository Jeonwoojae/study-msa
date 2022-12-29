package com.example.apigatewayservice.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class CustomFilter extends AbstractGatewayFilterFactory<CustomFilter.Config> {
    public CustomFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
//        Custom Pre Filter
        return ((exchange, chain) -> {
//            reactive의 라이브러리를 사용해야함
            ServerHttpRequest request = exchange.getRequest();
            ServerHttpResponse response = exchange.getResponse();

            log.info("Custom PRE filter: request id -> {}",request.getId());

//            Custom Post Filter
//            필터를 등록하고 비동기 방식 지원하기 위해 Mono 사용
            return chain.filter(exchange).then(Mono.fromRunnable(()-> {
                log.info("Custom POST filter: response code -> {]",response.getStatusCode());
            }));
        });
    }

    public static class Config{
        //config 정보 입력
    }
}
