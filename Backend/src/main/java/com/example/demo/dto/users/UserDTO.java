package com.example.demo.dto.users;

import com.example.demo.model.users.Address;
import com.example.demo.model.users.Role;
import com.example.demo.model.users.User;

public class UserDTO {

    private int id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String telephone;
    private Address address;
    private Role role;

    public UserDTO(){}

    public UserDTO(User user) {
        id = user.getId();
        name = user.getName();
        surname = user.getSurname();
        email = user.getEmail();
        password = user.getPassword();
        telephone = user.getTelephone();
        address = user.getAddress();
        role = user.getRole();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
