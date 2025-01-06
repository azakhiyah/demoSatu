package com.demoSatu.repository;

import java.util.Locale;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.demoSatu.model.Menu;
import com.github.javafaker.Faker;

@SpringBootTest
public class MenuRepositoryTests {

    @Autowired
    private MenuRepository menuRepository;
    @Test
    public void testSaveMenu() {
        Faker faker = new Faker(new Locale("id"));
        String menuName = faker.food().dish();
        String menuDescription = faker.food().ingredient();
        int price = faker.number().numberBetween(10000, 50000);

        Menu menu = new Menu();
        menu.setMenuName(menuName);
        menu.setMenuDescription(menuDescription);
        menu.setPrice(price);
        // menu.setMenuName("Nasi Goreng");
        // menu.setMenuDescription("Delicious Indonesian fried rice");
        // menu.setPrice(20000);

        // Act
        Menu savedMenu = menuRepository.save(menu);

        // Assert
        assertThat(savedMenu).isNotNull();
        assertThat(savedMenu.getMenuId()).isInstanceOf(UUID.class);
        assertThat(savedMenu.getMenuName()).isEqualTo(menuName);
        assertThat(savedMenu.getMenuDescription()).isEqualTo(menuDescription);
        assertThat(savedMenu.getPrice()).isEqualTo(price);
        
    }


    
}
