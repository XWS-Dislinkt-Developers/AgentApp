package com.example.demo.dto.companies;

import java.util.List;

public class CompanyRequestViewDTO {

    private int id;
    private String name;
    private String yearOfOpening;
    private String description;
    private String numberOfEmployees;

    public CompanyRequestViewDTO() {}

    public CompanyRequestViewDTO(int id, String name, String yearOfOpening, String description, String numberOfEmployees) {
        this.id = id;
        this.name = name;
        this.yearOfOpening = yearOfOpening;
        this.description = description;
        this.numberOfEmployees = numberOfEmployees;
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

    public String getYearOfOpening() {
        return yearOfOpening;
    }

    public void setYearOfOpening(String yearOfOpening) {
        this.yearOfOpening = yearOfOpening;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(String numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }
}
