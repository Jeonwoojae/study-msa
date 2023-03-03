package com.example.secondservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/second-service")
@Slf4j
public class SecondServiceController {
    Environment env;

    @Autowired
    public SecondServiceController(Environment env){
        this.env = env;
    }
    @GetMapping("/welcome")
    public String welcom(){
        return "Welcome to the Second Service.";
    }

    /**
     * 필터 적용하며 헤더값 주고 확인
     * @param header
     * @return
     */
    @GetMapping("/message")
    public String message(@RequestHeader("second-request") String header) {
        log.info(header);
        return "Hello World in Second Service.";
    }

    /**
     * 커스텀 pre, post 필터 적용 확인
     * @return
     */
    @GetMapping("/check")
    public String check(HttpServletRequest request){
        log.info("Server port={}",request.getServerPort());

        return String.format("Hi, there. This is a message from Second Service on PORT %s"
                , env.getProperty("local.server.port"));
//        랜덤으로 지정된 서버의 포트를 가져오는 방법 local.server.port
    }
}
