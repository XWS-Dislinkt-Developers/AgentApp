package com.example.demo.dto.companies;

import java.util.List;

public class CompanyRequestDTO {

    private String logo;
    private String name;
    private String yearOfOpening;
    private List<String> offices;
    private String description;
    private List<String> positions;
    private String numberOfEmployees;

    public CompanyRequestDTO() {}

    public CompanyRequestDTO(String logo, String name, String yearOfOpening, List<String> offices, List<String> positions, String description, String numberOfEmployees) {
       this.logo = logo;
        this.name = name;
        this.yearOfOpening = yearOfOpening;
        this.offices = offices;
        this.description = description;
        this.numberOfEmployees = numberOfEmployees;
        this.positions = positions;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
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

    public List<String> getOffices() {
        return offices;
    }

    public void setOffices(List<String> offices) {
        this.offices = offices;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getPositions() {
        return positions;
    }

    public void setPositions(List<String> positions) {
        this.positions = positions;
    }

    public String getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(String numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }
}
