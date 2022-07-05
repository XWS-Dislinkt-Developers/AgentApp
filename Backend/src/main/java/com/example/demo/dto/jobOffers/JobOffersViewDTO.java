package com.example.demo.dto.jobOffers;

import com.example.demo.enums.LevelOfExperience;

import java.util.Date;
import java.util.List;

public class JobOffersViewDTO {
    public int id;
    public String position;
    public LevelOfExperience levelOfExperience;
    public String jobDescription;
    public String dailyActivities;
    public List<String> requirements;
    public List<String> benefits;
    public Date expires;
    public String logoCompany;
    public String companyName;
    public double grade;

    public JobOffersViewDTO() {
    }


    public JobOffersViewDTO(int id, String position, LevelOfExperience levelOfExperience, String jobDescription, String dailyActivities, List<String> requirements, List<String> benefits, Date expires, String logoCompany, String companyName, double grade) {
        this.id = id;
        this.position = position;
        this.levelOfExperience = levelOfExperience;
        this.jobDescription = jobDescription;
        this.dailyActivities = dailyActivities;
        this.requirements = requirements;
        this.benefits = benefits;
        this.expires = expires;
        this.logoCompany = logoCompany;
        this.companyName = companyName;
        this.grade=grade;
    }
}
