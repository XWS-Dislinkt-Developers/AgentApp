package com.example.demo.dto.jobOffers;

import com.example.demo.enums.Engagement;
import com.example.demo.enums.LevelOfExperience;

import java.util.List;

public class SalaryAndBenefitsNewDTO {

    private int companyId;
    private String position;
    private double salary;
    private List<String> benefits;
    private LevelOfExperience levelOfExperience;
    private Engagement engagement;

    public SalaryAndBenefitsNewDTO(){}

    public SalaryAndBenefitsNewDTO(int companyId, String position, double salary, List<String> benefits, LevelOfExperience levelOfExperience, Engagement engagement) {
        this.companyId = companyId;
        this.position = position;
        this.salary = salary;
        this.benefits = benefits;
        this.levelOfExperience = levelOfExperience;
        this.engagement = engagement;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
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
