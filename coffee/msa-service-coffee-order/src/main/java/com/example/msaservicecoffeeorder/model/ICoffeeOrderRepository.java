package com.example.msaservicecoffeeorder.model;

import com.example.msaservicecoffeeorder.domain.OrderEntity;

public interface ICoffeeOrderRepository {
    public String coffeeOrderSave(OrderEntity orderEntity);
}
