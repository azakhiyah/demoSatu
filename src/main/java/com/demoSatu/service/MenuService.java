package com.demoSatu.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demoSatu.dao.MenuDao;
import com.demoSatu.dto.MenuDTO;
import com.demoSatu.model.Menu;

@Service
public class MenuService {
    private final MenuDao menuDao;

    public MenuService(MenuDao menuDao) {
        this.menuDao = menuDao;
    }

    public List<Menu> getAllMenu() {
        return menuDao.findAll();
    }

    public List<MenuDTO> getAllMenuDTO() {
        List<Menu> menus = menuDao.findAll();
        return menus.stream().map(menusDTO -> new MenuDTO(menusDTO.getMenuName(), menusDTO.getMenuDescription()))
                .toList();
    }

    public MenuDTO getMenuDTOByName(String menuName) {
        Menu menu = menuDao.findMenuByMenuName(menuName);
        return new MenuDTO(menu.getMenuName(), menu.getMenuDescription());
    }

    public List<Menu> getMenuByPrice(int price) {
        return menuDao.findMenuByPrice(price);
    }

    public Menu getMenuByName(String menuName) {
        return menuDao.findMenuByMenuName(menuName);
    }

    public Menu getMenuById(String menuId) {
        return menuDao.findById(menuId).get();
    }

    public Menu saveMenu(Menu menu) {
        // check if menuName already exists
        if (menuDao.existsByMenuName(menu.getMenuName())) {
            throw new IllegalArgumentException("Menu name already exists: " + menu.getMenuName());
        }
        System.out.println("Adding Menu: " + menu.getMenuName());
        return menuDao.save(menu);

    }

    public Menu editMenuById(Menu menu, int menuId) {
        return menuDao.save(menu);

    }

    public void deleteMenuById(String menuId) {
        menuDao.deleteById(menuId);
    }

}
