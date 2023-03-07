package com.example.msaservicecoffeeorder.service;

import com.example.msaservicecoffeeorder.domain.CoffeeOrderVo;
import com.example.msaservicecoffeeorder.domain.OrderEntity;
import com.example.msaservicecoffeeorder.model.ICoffeeOrderRepository;

public class CoffeeOrder implements ICoffeeOrder{
    private ICoffeeOrderRepository iCoffeeOrderRepository;
    public CoffeeOrder(ICoffeeOrderRepository iCoffeeOrderRepository) {
        this.iCoffeeOrderRepository = iCoffeeOrderRepository;
    }

    @Override
    public String coffeeOrder(CoffeeOrderVo coffeeOrderVo) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setOrderNumber(coffeeOrderVo.getOrderNumber());
        orderEntity.setCoffeeName(coffeeOrderVo.getCoffeeName());
        orderEntity.setCoffeeCount(coffeeOrderVo.getCoffeeCount());
        orderEntity.setCustomerName(coffeeOrderVo.getCustomerName());

        iCoffeeOrderRepository.coffeeOrderSave(orderEntity);

        return orderEntity.getId();
    }
}
