package com.demoSatu.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
//import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class SignUpForm {
    @NotEmpty(message = "Email is required.")
    @Size(min = 3, max = 255, message = "Full Name  must be between 3 and 255 characters.")
    private String fullName;
    
    @NotNull
    @NotEmpty(message = "Email is required.")
    @Email(message = "Please provide a valid email address.")
    private String email;
    
    @NotEmpty(message = "Phone number is required.")
    @Size(min = 3, max = 12, message = "Phone number must be between 3 and 12 characters.")
    private String phone;
    
    @NotEmpty
    @Size(min = 3, max = 12, message = "Password must be between 3 and 12 characters.")
    private String password;


    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



}
