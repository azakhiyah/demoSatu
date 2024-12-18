package com.demoSatu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demoSatu.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findOrderByMenu_MenuId(int menuId);    
}
