package com.example.msaservicecoffeemember.service;


import com.example.msaservicecoffeemember.domain.CoffeeOrderVo;
import com.example.msaservicecoffeemember.domain.OrderEntity;
import com.example.msaservicecoffeemember.model.ICoffeeOrderRepository;

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
