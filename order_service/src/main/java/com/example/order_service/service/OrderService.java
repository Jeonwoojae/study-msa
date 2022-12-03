package com.example.order_service.service;

import com.example.order_service.domain.OrderDomain;

import java.util.List;

public interface OrderService {
    public OrderDomain createOrder(OrderDomain order);
    public OrderDomain getOrder(Integer orderId);
    public OrderDomain updateOrder(OrderDomain order, Integer orderId);
    public void deleteOrder(Integer orderId) throws Exception;
    public List<OrderDomain> getAllOrders();
}
