package com.example.msaservicecoffeeorder.springboot.service;

import com.example.msaservicecoffeeorder.model.ICoffeeOrderRepository;
import com.example.msaservicecoffeeorder.service.CoffeeOrder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CoffeeOrderServiceImpl extends CoffeeOrder {

    public CoffeeOrderServiceImpl(ICoffeeOrderRepository iCoffeeOrderRepository) {
        super(iCoffeeOrderRepository);
    }
}
