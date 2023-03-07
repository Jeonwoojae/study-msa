package com.example.msaservicecoffeeorder.springboot.messageq;

import com.example.msaservicecoffeeorder.domain.CoffeeOrderVo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public CoffeeOrderVo send(String kafkaTopic, CoffeeOrderVo coffeeOrderVo) {

        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = "";
        try {
            jsonInString = mapper.writeValueAsString(coffeeOrderVo);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        kafkaTemplate.send(kafkaTopic, jsonInString);

        System.out.println("KafkaProducer send data from msa-service-coffee-order: " + coffeeOrderVo);

        return coffeeOrderVo;
    }
}
