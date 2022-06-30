package com.example.demo.dto.companies;

import java.util.List;

public class CompanyChangeDTO {

    private int id;
    private String name;
    private String yearOfOpening;
    private String description;
    private List<String> offices;
    private List<String> positions;
    private double grade;
    private String logoImage;

    public CompanyChangeDTO() {}

    public CompanyChangeDTO(int id, String name, String yearOfOpening, String description, List<String> offices, List<String> positions, double grade, String logoImage) {
        this.id = id;
        this.name = name;
        this.yearOfOpening = yearOfOpening;
        this.description = description;
        this.offices = offices;
        this.positions = positions;
        this.grade = grade;
        this.logoImage = logoImage;
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

    public List<String> getOffices() {
        return offices;
    }

    public void setOffices(List<String> offices) {
        this.offices = offices;
    }

    public List<String> getPositions() {
        return positions;
    }

    public void setPositions(List<String> positions) {
        this.positions = positions;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public String getLogoImage() {
        return logoImage;
    }

    public void setLogoImage(String logoImage) {
        this.logoImage = logoImage;
    }
}
