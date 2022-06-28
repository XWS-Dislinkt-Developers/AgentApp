package com.example.demo.dto.users;

public class UserRequest {

    private String password;
    private String name;
    private String surname;
    private String email;
    private String role;
    private String telephone;
    private String country;
    private String city;
    private String street;
    private String number;

    public UserRequest() {}

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name;}

    public String getSurname() { return surname; }

    public void setSurname(String surname) { this.surname = surname; }
}
