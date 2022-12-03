package com.example.order_service.controller;

import com.example.order_service.domain.OrderDomain;
import com.example.order_service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping()
    public OrderDomain createOrder(@RequestBody OrderDomain order){
        return orderService.createOrder(order);
    }

    @GetMapping()
    public ResponseEntity<List<OrderDomain>> getOrder(){
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    @PutMapping("/{id}")
    public OrderDomain updateOrder(@PathVariable Integer id, @RequestBody OrderDomain order) throws Exception{
        return orderService.updateOrder(order, id);
    }

    @DeleteMapping("/{id}")
    public String deleteOrder(@PathVariable Integer id) throws Exception{
        orderService.deleteOrder(id);

        return "Order with id: "+id+" deleted.";
    }
}
