package com.example.demo.dto.jobOffers;

import com.example.demo.enums.Engagement;
import com.example.demo.enums.LevelOfExperience;

import java.util.List;

public class SalaryAndBenefitsDTO {

    private int id;
    private String position;
    private double salary;
    private List<String> benefits;
    private LevelOfExperience levelOfExperience;
    private Engagement engagement;

    public SalaryAndBenefitsDTO(){}

    public SalaryAndBenefitsDTO(int id, String position, double salary, List<String> benefits, LevelOfExperience levelOfExperience, Engagement engagement) {
        this.id = id;
        this.position = position;
        this.salary = salary;
        this.benefits = benefits;
        this.levelOfExperience = levelOfExperience;
        this.engagement = engagement;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public List<String> getBenefits() {
        return benefits;
    }

    public void setBenefits(List<String> benefits) {
        this.benefits = benefits;
    }

    public LevelOfExperience getLevelOfExperience() {
        return levelOfExperience;
    }

    public void setLevelOfExperience(LevelOfExperience levelOfExperience) {
        this.levelOfExperience = levelOfExperience;
    }

    public Engagement getEngagement() {
        return engagement;
    }

    public void setEngagement(Engagement engagement) {
        this.engagement = engagement;
    }
}
