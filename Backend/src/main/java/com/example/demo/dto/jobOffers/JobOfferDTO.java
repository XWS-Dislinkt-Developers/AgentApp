package com.example.demo.dto.jobOffers;

import com.example.demo.enums.LevelOfExperience;

import java.util.Date;
import java.util.List;

public class JobOfferDTO {

    private int id;
    private String position;
    private LevelOfExperience levelOfExperience;
    private String jobDescription;
    private String dailyActivities;
    private String requirements;
    private Boolean promoteOnDislinkt;
    private List<String> benefits;
    private Date expires;

    public JobOfferDTO() {}

    public JobOfferDTO(String position, LevelOfExperience levelOfExperience, String jobDescription, String dailyActivities, String requirements, Boolean promoteOnDislinkt, List<String> benefits, Date expires) {
        this.position = position;
        this.levelOfExperience = levelOfExperience;
        this.jobDescription = jobDescription;
        this.dailyActivities = dailyActivities;
        this.requirements = requirements;
        this.promoteOnDislinkt = promoteOnDislinkt;
        this.benefits = benefits;
        this.expires = expires;
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

    public LevelOfExperience getLevelOfExperience() {
        return levelOfExperience;
    }

    public void setLevelOfExperience(LevelOfExperience levelOfExperience) {
        this.levelOfExperience = levelOfExperience;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getDailyActivities() {
        return dailyActivities;
    }

    public void setDailyActivities(String dailyActivities) {
        this.dailyActivities = dailyActivities;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public Boolean getPromoteOnDislinkt() {
        return promoteOnDislinkt;
    }

    public void setPromoteOnDislinkt(Boolean promoteOnDislinkt) {
        this.promoteOnDislinkt = promoteOnDislinkt;
    }

    public List<String> getBenefits() {
        return benefits;
    }

    public void setBenefits(List<String> benefits) {
        this.benefits = benefits;
    }

    public Date getExpires() {
        return expires;
    }

    public void setExpires(Date expires) {
        this.expires = expires;
    }
}
