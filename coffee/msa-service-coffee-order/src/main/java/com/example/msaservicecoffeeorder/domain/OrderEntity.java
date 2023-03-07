package com.example.msaservicecoffeeorder.domain;

import lombok.Data;

@Data
public class OrderEntity {
    private String id;
    // 주문 번호
    private String orderNumber;
    // 커피 종류
    private String coffeeName;
    // 커피 개수
    private String coffeeCount;
    // 회원명
    private String customerName;
}