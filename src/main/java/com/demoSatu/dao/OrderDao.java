package com.demoSatu.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demoSatu.model.Order;

public interface OrderDao extends JpaRepository<Order, String> {
    List<Order> findOrderByMenuId(String menuId);    
}
