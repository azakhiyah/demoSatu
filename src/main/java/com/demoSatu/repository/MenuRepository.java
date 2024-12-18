package com.demoSatu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demoSatu.model.Menu;

public interface MenuRepository extends JpaRepository<Menu, Integer> {
    List<Menu>findMenuByPrice(int price);
    Menu findMenuByMenuName(String menuName);
    
}
