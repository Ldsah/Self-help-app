package com.example.backend.auth.service;

import com.example.backend.auth.model.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Set;

public class UserData {
    private Long id;
    private String username;
    private String email;
    @JsonIgnore
    private String password;
    private String name;
    private String phone;
    private String gender;
    private Integer age;
    private Set<Role> roles;


    public UserData(Long id, String username, String email, String password,Set<Role> roles, String name, String phone, String gender, Integer age) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.name = name;
        this.phone = phone;
        this.gender = gender;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
