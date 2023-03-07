package com.example.msaservicecoffeeorder.springboot.repository;

import com.example.msaservicecoffeeorder.domain.OrderEntity;
import com.example.msaservicecoffeeorder.model.ICoffeeOrderRepository;
import com.example.msaservicecoffeeorder.springboot.repository.jpa.ICoffeeOrderJpaRepository;
import com.example.msaservicecoffeeorder.springboot.repository.jpa.OrderEntityJpo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CoffeeOrderRepository implements ICoffeeOrderRepository {
    @Autowired
    private ICoffeeOrderJpaRepository iCoffeeOrderJpaRepository;
    @Override
    public String coffeeOrderSave(OrderEntity orderEntity) {
        OrderEntityJpo orderEntityJpo = new OrderEntityJpo();
        orderEntityJpo.setOrderNumber(orderEntity.getOrderNumber());
        orderEntityJpo.setCoffeeName(orderEntity.getCoffeeName());
        orderEntityJpo.setCoffeeCount(orderEntity.getCoffeeCount());
        orderEntityJpo.setCustomerName(orderEntity.getCustomerName());

        iCoffeeOrderJpaRepository.save(orderEntityJpo);

        return orderEntityJpo.getId();
    }
}
