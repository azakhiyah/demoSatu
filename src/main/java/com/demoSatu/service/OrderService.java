package com.demoSatu.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demoSatu.dao.OrderDao;
import com.demoSatu.model.Order;

@Service
public class OrderService {
    private final OrderDao orderDao;

    public OrderService(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public List<Order> getOrderByMenu_MenuId(String menuId) {
        return orderDao.findOrderByMenuId(menuId);
    }

}
