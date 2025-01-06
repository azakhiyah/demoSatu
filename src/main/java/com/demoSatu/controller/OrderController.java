package com.demoSatu.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demoSatu.model.Order;
import com.demoSatu.response.ApiResponse;
import com.demoSatu.security.JWTTokenProvider;
import com.demoSatu.service.OrderService;

@RestController
public class OrderController {
    private final OrderService orderService;
    private final JWTTokenProvider jwtTokenProvider;

    public OrderController(OrderService orderService, JWTTokenProvider jwtTokenProvider) {
        this.orderService = orderService;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @GetMapping("/order/menuId")
    private ResponseEntity<ApiResponse> getOrderByMenu_MenuId(@RequestParam UUID menuId,@RequestParam String token) {
        try{

            if(!jwtTokenProvider.validateToken(token)) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ApiResponse("Invalid Token", null));
            }

            List<Order> orders = orderService.getOrderByMenu_MenuId(menuId);
            if (orders.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Order Not found", null));
            }
                return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Orders found", orders));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(), null));
        }
    }

}
