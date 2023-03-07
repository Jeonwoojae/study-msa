package com.example.msaservicecoffeestatus.springboot.messageq;

import com.example.msaservicecoffeestatus.springboot.repository.ICoffeeStatusMapper;
import com.example.msaservicecoffeestatus.springboot.repository.dvo.OrderStatusDVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @Autowired
    ICoffeeStatusMapper iCoffeeStatusMapper;

    @KafkaListener(topics="kafka-test")
    public void processMessage(String kafkaMessage) {

        System.out.println("kafkaMessage : =====> " + kafkaMessage);

        OrderStatusDVO orderStatusDVO = new OrderStatusDVO();
        orderStatusDVO.setOrderHistory(kafkaMessage);

        iCoffeeStatusMapper.insertCoffeeOrderStatus(orderStatusDVO);
    }
}