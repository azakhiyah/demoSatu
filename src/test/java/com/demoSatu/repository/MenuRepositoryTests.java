package com.demoSatu.repository;

import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.demoSatu.dao.MenuDao;
import com.demoSatu.model.Menu;
import com.github.javafaker.Faker;

@SpringBootTest
public class MenuRepositoryTests {

    @Autowired
    private MenuDao menuRepository;
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
        //assertThat(savedMenu.getMenuId()).isInstanceOf(UUID.class);
        assertThat(savedMenu.getId())
        .matches(uuid -> uuid.matches("^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$")); // UUID format check
        assertThat(savedMenu.getMenuName()).isEqualTo(menuName);
        assertThat(savedMenu.getMenuDescription()).isEqualTo(menuDescription);
        assertThat(savedMenu.getPrice()).isEqualTo(price);
        
    }


    
}
