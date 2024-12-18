package com.demoSatu.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demoSatu.model.Order;
import com.demoSatu.repository.OrderRepository;

@Service
public class OrderService {
    private final OrderRepository orderRepository;



    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getOrderByMenu_MenuId(int menuId) {
        return orderRepository.findOrderByMenu_MenuId(menuId);
    }
    
}
