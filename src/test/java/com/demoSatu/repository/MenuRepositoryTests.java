package com.demoSatu.repository;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

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

    @Test
    public void testGetDataById() {
        Faker faker = new Faker(new Locale("id"));
        String menuName = faker.food().dish();
        String menuDescription = faker.food().ingredient();
        int price = faker.number().numberBetween(10000, 50000);

        Menu menu = new Menu();
        menu.setMenuName(menuName);
        menu.setMenuDescription(menuDescription);
        menu.setPrice(price);

        Menu savedMenu = menuRepository.save(menu);

        //act
        Optional<Menu> foundMenu = menuRepository.findById(savedMenu.getId());

        // Assert
        assertThat(foundMenu).isPresent();
        assertThat(foundMenu.get().getId())
        .matches(uuid -> uuid.matches("^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$")); // UUID format check
        assertThat(foundMenu.get().getMenuName()).isEqualTo(menuName);
        assertThat(foundMenu.get().getMenuDescription()).isEqualTo(menuDescription);
        assertThat(foundMenu.get().getPrice()).isEqualTo(price);

    }

    @Test
    public void testGetAllMenu() {
        Faker faker = new Faker(new Locale("id"));
        String menuName = faker.food().dish();
        String menuName2 = faker.food().dish();
        String menuDescription = faker.food().ingredient();
        String menuDescription2 = faker.food().ingredient();
        int price = faker.number().numberBetween(1000, 5000);
        int price2 = faker.number().numberBetween(1000, 5000);


        Menu menu1 = new Menu();
        menu1.setMenuName(menuName);
        menu1.setMenuDescription(menuDescription);
        menu1.setPrice(price);

        Menu menu2 = new Menu();
        menu2.setMenuName(menuName2);
        menu2.setMenuDescription(menuDescription2);
        menu2.setPrice(price2);

        menuRepository.save(menu1);
        menuRepository.save(menu2);

        List<Menu> menus = menuRepository.findAll();

        assertThat(menus).isNotEmpty();
        assertThat(menus.size()).isGreaterThanOrEqualTo(2);
    }

    @Test
    public void testUpdateMenuById() {
        Faker faker = new Faker(new Locale("id"));
        String menuName = faker.food().sushi();
        String menuDescription = faker.food().ingredient();
        int price = faker.number().numberBetween(1000, 5000);

        Menu menu = new Menu();
        menu.setMenuName(menuName);
        menu.setMenuDescription(menuDescription);
        menu.setPrice(price);
        Menu mn = menuRepository.save(menu);

        mn.setMenuDescription("Ikan kembung digoreng garing");
        mn.setPrice(100);
        Menu updatedMenu = menuRepository.save(mn);
        
        assertThat(updatedMenu).isNotNull();
        assertThat(updatedMenu.getMenuDescription()).isEqualTo("Ikan kembung digoreng garing");
        assertThat(updatedMenu.getPrice()).isEqualTo(100);
       
    }

    @Test
    public void testDeleteMenuById() {
        Faker faker = new Faker(new Locale("id"));
        String menuName = faker.food().spice();
        String menuDescription  = faker.food().ingredient();
        int price = faker.number().numberBetween(1000, 2000);

        Menu menu = new Menu();
        menu.setMenuName(menuName);
        menu.setMenuDescription(menuDescription);
        menu.setPrice(price);

        Menu savedMenu = menuRepository.save(menu);
        menuRepository.deleteById(savedMenu.getId());
        Optional<Menu> deletedMenu = menuRepository.findById(savedMenu.getId());

        assertThat(deletedMenu).isNotPresent();

    }


    
}
