package com.example.msaservicecoffeestatus.springboot.repository.dvo;

import lombok.Data;

@Data
public class OrderStatusDVO {
    private String id;
    private String orderHistory; //주문내역
}