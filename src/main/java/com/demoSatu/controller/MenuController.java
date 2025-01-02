package com.demoSatu.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demoSatu.dto.MenuDTO;
import com.demoSatu.model.Menu;
import com.demoSatu.response.ApiResponse;
import com.demoSatu.security.JWTTokenProvider;
import com.demoSatu.service.MenuService;

@RestController
public class MenuController {
    private final MenuService menuService;
    private final JWTTokenProvider jwtTokenProvider;



    public MenuController(MenuService menuService, JWTTokenProvider jwtTokenProvider) {
        this.menuService = menuService;
        this.jwtTokenProvider = jwtTokenProvider;
    }
   

    @GetMapping("/menu")
    private ResponseEntity<ApiResponse> getAllMenu(@RequestParam String token){
        try {

            if(!jwtTokenProvider.validateToken(token)) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ApiResponse("Invalid Token", null));
            }

            List<Menu> menus = menuService.getAllMenu();
            if(menus.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Menu not found", null));        
            }
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Menu found", menus ));
        }catch(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(), null));
        }
    }

    @GetMapping("/menuDTO")
    private ResponseEntity<ApiResponse> getAllMenuDTO(@RequestParam String token){
        try {
            if(!jwtTokenProvider.validateToken(token)) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ApiResponse("Invalid Token", null));
            }

            List<MenuDTO> menus = menuService.getAllMenuDTO();
            if(menus.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Menu not found", null));        
            }
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Menu found", menus ));
        }catch(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(), null));
        }
    }

    @GetMapping("/menuDTO/name")
    private ResponseEntity<ApiResponse> getMenuDTOByName(@RequestParam String token,@RequestParam String menuName){
        try {
            if(!jwtTokenProvider.validateToken(token)) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ApiResponse("Invalid Token", null));
            }

            MenuDTO menu = menuService.getMenuDTOByName(menuName);
            if(menu == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Menu not found", null));        
            }
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Menu found", menu ));
        }catch(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(), null));
        }
    }

    @GetMapping("/menu/menuId")
    private ResponseEntity<ApiResponse> getMenuById(@RequestParam String token,@RequestParam int menuId){
        try {
            if(!jwtTokenProvider.validateToken(token)) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ApiResponse("Invalid Token", null));
            }

            Menu menu = menuService.getMenuById(menuId);
            if(menu == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Menu not found", null));        
            }
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Menu found", menu ));
        }catch(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(), null));
        }
    }


    @GetMapping("/menu/price")
    private ResponseEntity<ApiResponse> getMenuByPrice(@RequestParam String token,@RequestParam int price){
        try {
            if(!jwtTokenProvider.validateToken(token)) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ApiResponse("Invalid Token", null));
            }

            List<Menu> menus = menuService.getMenuByPrice(price);
            if(menus.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Menu not found", null));        
            }
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Menu found", menus ));
        }catch(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(), null));
        }
    }



    @GetMapping("/menu/name")
    private ResponseEntity<ApiResponse> getMenuByName(@RequestParam String token,@RequestParam String menuName){
        try {
            if(!jwtTokenProvider.validateToken(token)) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ApiResponse("Invalid Token", null));
            }

            Menu menu = menuService.getMenuByName(menuName);
            if(menu == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Menu not found", null));        
            }
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Menu found", menu ));
        }catch(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(), null));
        }
    }

    @PostMapping("/menu")
    private ResponseEntity<ApiResponse> saveMenu(@RequestParam String token,@RequestBody Menu menu){
        try {
            if(!jwtTokenProvider.validateToken(token)) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ApiResponse("Invalid Token", null));
            }
            
            Menu savedMenu = menuService.saveMenu(menu);
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Menu saved", savedMenu ));
        }catch(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(), null));
        }
    }

    @PutMapping("/menu/menuId")
    private ResponseEntity<ApiResponse> updateMenuById(@RequestParam String token,@RequestBody Menu menu,@RequestParam int menuId){
        try {
            if(!jwtTokenProvider.validateToken(token)) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ApiResponse("Invalid Token", null));
            }

            Menu menuTarget = menuService.getMenuById(menuId);
            if(menuTarget == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Menu not found", null));        
            }
            menuService.saveMenu(menu);
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Menu found", menu ));
        }catch(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(), null));
        }
    }

    @DeleteMapping("/menu/menuId")
    private ResponseEntity<ApiResponse> deleteMenuById(@RequestParam String token,@RequestParam int menuId){
        try {
            if(!jwtTokenProvider.validateToken(token)) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ApiResponse("Invalid Token", null));
            }

            Menu menuTarget = menuService.getMenuById(menuId);
            if(menuTarget == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Menu not found", null));        
            }
            menuService.deleteMenuById(menuId);
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Menu is deleted", null ));
        }catch(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(), null));
        }
    }

}
