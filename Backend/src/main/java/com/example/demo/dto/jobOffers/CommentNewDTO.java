package com.example.demo.dto.jobOffers;

import com.example.demo.enums.Engagement;
import com.example.demo.enums.LevelOfExperience;

public class CommentNewDTO {

    private int companyId;
    private String position;
    private boolean currentlyEmployed;
    private String positive;
    private String negative;
    private String projects;
    private double grade;
    private LevelOfExperience levelOfExperience;
    private Engagement engagement;
    private String title;

    public CommentNewDTO(){}

    public CommentNewDTO(int companyId, String position, boolean currentlyEmployed, String positive, String negative, String projects, double grade, LevelOfExperience levelOfExperience, Engagement engagement, String title) {
        this.companyId = companyId;
        this.position = position;
        this.currentlyEmployed = currentlyEmployed;
        this.positive = positive;
        this.negative = negative;
        this.projects = projects;
        this.grade = grade;
        this.levelOfExperience = levelOfExperience;
        this.engagement = engagement;
        this.title = title;
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

    public boolean isCurrentlyEmployed() {
        return currentlyEmployed;
    }

    public void setCurrentlyEmployed(boolean currentlyEmployed) {
        this.currentlyEmployed = currentlyEmployed;
    }

    public String getPositive() {
        return positive;
    }

    public void setPositive(String positive) {
        this.positive = positive;
    }

    public String getNegative() {
        return negative;
    }

    public void setNegative(String negative) {
        this.negative = negative;
    }

    public String getProjects() {
        return projects;
    }

    public void setProjects(String projects) {
        this.projects = projects;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }



}
