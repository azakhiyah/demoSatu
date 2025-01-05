package com.demoSatu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demoSatu.model.Menu;

public interface MenuRepository extends JpaRepository<Menu, Integer> {
    List<Menu>findMenuByPrice(int price);
    Menu findMenuByMenuName(String menuName); // For retrieving the menu by name
    boolean existsByMenuName(String menuName); // For checking duplicate menuName
    
}
