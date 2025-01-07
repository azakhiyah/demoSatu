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

    public List<Order> getAllOrder() {
        return orderDao.findAll();
    }

    public Order getOrderById (String id) {
        return orderDao.findById(id).get();
    }

    public Order saveOrder (Order order) {
        return orderDao.save(order);
    }

    public Order updateOrderById (Order order, String id) {
        return orderDao.save(order);
    }

    public void deleteOrderById (String id) {
        orderDao.deleteById(id);
    }

}
