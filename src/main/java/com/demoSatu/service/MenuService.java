package com.demoSatu.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demoSatu.dto.MenuDTO;
import com.demoSatu.model.Menu;
import com.demoSatu.repository.MenuRepository;

@Service
public class MenuService {
        private final MenuRepository menuRepository;

        public MenuService (MenuRepository menuRepository) {
            this.menuRepository=menuRepository;
        }

        public List<Menu> getAllMenu()  {
            return menuRepository.findAll();
        }

        public List<MenuDTO> getAllMenuDTO()  {
            List<Menu> menus = menuRepository.findAll();
            return menus.stream().map(menusDTO -> new MenuDTO(menusDTO.getMenuName(), menusDTO.getMenuDescription())).toList();
        }

        public MenuDTO getMenuDTOByName(String menuName)  {
            Menu menu = menuRepository.findMenuByMenuName(menuName);
            return new MenuDTO(menu.getMenuName(), menu.getMenuDescription());
        }

        public List<Menu> getMenuByPrice(int price)  {
            return menuRepository.findMenuByPrice(price);
        }


        public Menu getMenuByName(String menuName)  {
            return menuRepository.findMenuByMenuName(menuName);
        }

        public Menu getMenuById(int menuId)  {
            return menuRepository.findById(menuId).get();
        }


        public Menu saveMenu(Menu menu)  {
            System.out.println("Adding Menu: " + menu.getMenuName());
            return menuRepository.save(menu);
            
        }

        public Menu editMenuById(Menu menu, int menuId)  {
            return menuRepository.save(menu);
           
        }

        public void deleteMenuById(int menuId)  {
            menuRepository.deleteById(menuId);
        }



}
