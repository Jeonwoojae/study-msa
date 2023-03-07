package com.example.msaservicecoffeeorder.springboot.rest;

import com.example.msaservicecoffeeorder.domain.CoffeeOrderVo;
import com.example.msaservicecoffeeorder.springboot.messageq.KafkaProducer;
import com.example.msaservicecoffeeorder.springboot.service.CoffeeOrderServiceImpl;
import com.example.msaservicecoffeeorder.springboot.service.IMsaServiceCoffeeMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoffeeOrderRestController {
    @Autowired
    private CoffeeOrderServiceImpl coffeeOrderServiceImpl;

    @Autowired
    private KafkaProducer kafkaProducer;

    @Autowired
    private IMsaServiceCoffeeMember iMsaServiceCoffeeMember;

    @RequestMapping(value = "/coffeeOrder", method = RequestMethod.POST)
    public ResponseEntity<CoffeeOrderVo> coffeeOrder(@RequestBody CoffeeOrderVo coffeeOrderVo) {

        //is member
        if(iMsaServiceCoffeeMember.coffeeMember(coffeeOrderVo.getCustomerName())) {
            System.out.println(coffeeOrderVo.getCustomerName() + " is a member!");
        }

        //coffee order
        coffeeOrderServiceImpl.coffeeOrder(coffeeOrderVo);

        //kafka
        kafkaProducer.send("kafka-test", coffeeOrderVo);

        return new ResponseEntity<CoffeeOrderVo>(coffeeOrderVo, HttpStatus.OK);
    }
}
