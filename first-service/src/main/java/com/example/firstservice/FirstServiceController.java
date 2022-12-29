package com.example.firstservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/first-service")
@Slf4j
public class FirstServiceController {
    @GetMapping("/welcome")
    public String welcom(){
        return "Welcome to the First Service.";
    }

    /**
     * 필터 적용하며 헤더값 주고 확인
     * @param header
     * @return
     */
    @GetMapping("/message")
    public String message(@RequestHeader("first-request") String header) {
        log.info(header);
        return "Hello World in First Service.";
    }

    /**
     * 커스텀 pre, post필터 적용 확인
     * @return
     */
    @GetMapping("/check")
    public String check(){
        return "Hi, there. This is a message from First Service";
    }
}
