package com.demoSatu.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demoSatu.response.ApiResponse;
import com.demoSatu.security.JWTTokenProvider;

@RestController
public class TokenController {
    private final JWTTokenProvider jwtTokenProvider;

    private final String uname;


    public TokenController(JWTTokenProvider jwtTokenProvider, @Value("${spring.security.user.name}") String uname) {
        this.jwtTokenProvider = jwtTokenProvider;
        this.uname = uname;
    }

    @GetMapping("/getToken")
    private ResponseEntity<ApiResponse> getToken() {
        String token="";
        token = jwtTokenProvider.generateToken(uname);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Ini tokennya", token));
    }     
}
