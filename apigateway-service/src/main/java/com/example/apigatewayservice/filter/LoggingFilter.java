package com.example.apigatewayservice.filter;

import lombok.Data;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.OrderedGatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class LoggingFilter extends AbstractGatewayFilterFactory<LoggingFilter.Config> {
    public LoggingFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
//        Custom Pre Filter
//        return ((exchange, chain) -> {
////            reactive의 라이브러리를 사용해야함
//            ServerHttpRequest request = exchange.getRequest();
//            ServerHttpResponse response = exchange.getResponse();
//
//            log.info("Global filter baseMessage: {}",config.getBaseMessage());
//
////            pre필터 작동 확인
//            if(config.isPreLogger()){
//                log.info("Global filter Start: request id -> {}",request.getId());
//            }
//            return chain.filter(exchange).then(Mono.fromRunnable(()-> {
//                if (config.isPostLogger()){
//                    log.info("Global Filter End: response code -> {]",response.getStatusCode());
//                }
//            }));
//        });

        GatewayFilter filter = new OrderedGatewayFilter((exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();
            ServerHttpResponse response = exchange.getResponse();

            log.info("Logging filter baseMessage: {}",config.getBaseMessage());

//            pre필터 작동 확인
            if(config.isPreLogger()){
                log.info("Logging PRE filter: request id -> {}",request.getId());
            }
            return chain.filter(exchange).then(Mono.fromRunnable(()-> {
                if (config.isPostLogger()){
                    log.info("Logging POST Filter: response code -> {]",response.getStatusCode());
                }
            }));
        }, Ordered.HIGHEST_PRECEDENCE);

        return filter;
    }

    @Data
    @Getter
    public static class Config{
        //config 정보 입력
        private String baseMessage;
        private boolean preLogger;
        private boolean postLogger;
    }
}
