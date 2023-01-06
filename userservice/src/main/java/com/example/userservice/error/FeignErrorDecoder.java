package com.example.userservice.error;

import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class FeignErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        switch (response.status()){
            case 400:
                break;
            case 404:
                if (methodKey.contains("getOrders")){
//                    getOrders에서 404에러가 났을 때
                    return new ResponseStatusException(HttpStatus.valueOf(response.status()),
                            "User's orders is empty."); //하드코딩이 아니라 설정 파일에서도 가능
                }
                break;
            default:
                return new Exception(response.reason());
        }
        return null;
    }
}
