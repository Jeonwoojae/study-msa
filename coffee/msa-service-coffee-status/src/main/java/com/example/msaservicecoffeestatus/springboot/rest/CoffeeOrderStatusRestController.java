package com.example.msaservicecoffeestatus.springboot.rest;

import com.example.msaservicecoffeestatus.springboot.repository.ICoffeeStatusMapper;
import com.example.msaservicecoffeestatus.springboot.repository.dvo.OrderStatusDVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoffeeOrderStatusRestController {

    @Autowired
    ICoffeeStatusMapper iCoffeeStatusMapper;

    @RequestMapping(value = "/coffeeOrderStatus", method = RequestMethod.POST)
    public ResponseEntity<OrderStatusDVO> coffeeOrderStatus() {

        OrderStatusDVO orderStatusDVO = iCoffeeStatusMapper.selectCoffeeOrderStatus();

        return new ResponseEntity<OrderStatusDVO>(orderStatusDVO, HttpStatus.OK);
    }

    @RequestMapping(value = "/createStatusTable", method = RequestMethod.PUT)
    public void createStatusTable() {
        iCoffeeStatusMapper.createStatusTable();
    }
}