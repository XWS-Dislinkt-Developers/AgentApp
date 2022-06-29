package com.example.demo.dto.companies;

import java.util.List;

public class CompanyRequestDTO {

    private String name;
    private String yearOfOpening;
    private List<String> offices;
    private String description;
    private List<String> positions;

    public CompanyRequestDTO() {}

    public CompanyRequestDTO(String name, String yearOfOpening, List<String> offices, String description) {
        this.name = name;
        this.yearOfOpening = yearOfOpening;
        this.offices = offices;
        this.description = description;
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
}
