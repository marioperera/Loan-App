package com.loanapp.demo.Models;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String salt;
    @Column
    private String username;
    @Column
    private String password;

    @Column
    @Email
    private String email;
    @Column
    private String role;

    public Users(){}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Users(Long id, String salt, String username, String password, String role) {
        this.id = id;
        this.salt = salt;
        this.username = username;
        this.password = password;
        this.role = role;
    }
}
