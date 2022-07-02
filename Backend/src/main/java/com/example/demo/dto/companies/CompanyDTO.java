package com.example.demo.dto.companies;

import java.util.List;

public class CompanyDTO {

    private int id;
    private String name;
    private String yearOfOpening;
    private String description;
    private List<String> offices;
    private double grade;
    private String logoImage;
    private String numberOfEmployees;

    public CompanyDTO(){

    }

    public CompanyDTO(int id, String name, String yearOfOpening, String description, List<String> offices, double grade, String logoImage, String numberOfEmployees) {
        this.id = id;
        this.name = name;
        this.yearOfOpening = yearOfOpening;
        this.description = description;
        this.offices = offices;
        this.grade = grade;
        this.logoImage = logoImage;
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

    public List<String> getPositions() {
        return offices;
    }

    public void setPositions(List<String> positions) {
        this.offices = positions;
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

    public List<String> getOffices() {
        return offices;
    }

    public void setOffices(List<String> offices) {
        this.offices = offices;
    }

    public String getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(String numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }
}
