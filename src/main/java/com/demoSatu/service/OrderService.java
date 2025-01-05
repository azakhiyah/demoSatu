package com.demoSatu.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.demoSatu.model.Order;
import com.demoSatu.repository.OrderRepository;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getOrderByMenu_MenuId(UUID menuId) {
        return orderRepository.findOrderByMenu_MenuId(menuId);
    }

}
