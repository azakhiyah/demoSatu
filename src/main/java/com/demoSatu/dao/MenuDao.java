package com.demoSatu.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demoSatu.model.Menu;

public interface MenuDao extends JpaRepository<Menu, String> {
    List<Menu>findMenuByPrice(int price);
    Menu findMenuByMenuName(String menuName); // For retrieving the menu by name
    boolean existsByMenuName(String menuName); // For checking duplicate menuName
    
}
