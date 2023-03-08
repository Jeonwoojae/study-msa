package com.example.msaservicecoffeeorder.springboot.service;


import com.example.msaservicecoffeeorder.domain.repository.IOrderRepository;
import com.example.msaservicecoffeeorder.domain.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class OrderServiceImpl extends OrderService {

    public OrderServiceImpl(IOrderRepository iOrderRepository) {

        super(iOrderRepository);
    }
}