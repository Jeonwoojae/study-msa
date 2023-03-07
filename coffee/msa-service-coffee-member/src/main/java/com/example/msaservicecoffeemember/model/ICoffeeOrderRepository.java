package com.example.msaservicecoffeemember.model;


import com.example.msaservicecoffeemember.domain.OrderEntity;

public interface ICoffeeOrderRepository {
    public String coffeeOrderSave(OrderEntity orderEntity);
}
