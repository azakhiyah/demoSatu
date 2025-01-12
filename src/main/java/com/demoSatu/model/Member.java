package com.demoSatu.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity @Data @Table(name="members")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @NotNull
    @NotEmpty
    @Size(min= 3, max = 255)
    private String fullName;

    @NotNull @NotEmpty @Email
    @Size(min = 3, max = 50)
    private String email;

    @NotNull @NotEmpty
    @Size(min = 3, max = 50)
    private String nomor_handphone;

    @NotNull @NotEmpty
    @Size(min = 3, max = 12)
    private String password;


    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public @NotNull @NotEmpty @Size(min = 3, max = 255) String getFullName() {
        return this.fullName;
    }

    public void setFullName(@NotNull @NotEmpty @Size(min = 3, max = 255) String fullName) {
        this.fullName = fullName;
    }

    public  @NotNull @NotEmpty @Email @Size(min = 3, max = 50) String getEmail() {
        return this.email;
    }

    public void setEmail(@NotNull @NotEmpty @Email @Size(min = 3, max = 50) String email) {
        this.email = email;
    }

    public @NotNull @NotEmpty @Size(min = 3, max = 50) String getNomor_handphone() {
        return this.nomor_handphone;
    }

    public void setNomor_handphone(@NotNull @NotEmpty @Size(min = 3, max = 50) String nomor_handphone) {
        this.nomor_handphone = nomor_handphone;
    }

    public @NotNull @NotEmpty @Size(min = 3, max = 12) String getPassword() {
        return this.password;
    }

    public void setPassword(@NotNull @NotEmpty @Size(min = 3, max = 50) String password) {
        this.password = password;
    }


    
}
