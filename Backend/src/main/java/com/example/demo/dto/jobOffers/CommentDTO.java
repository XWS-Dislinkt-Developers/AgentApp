package com.example.demo.dto.jobOffers;

import com.example.demo.enums.Engagement;
import com.example.demo.enums.LevelOfExperience;
import com.example.demo.model.jobOffers.Comment;

public class CommentDTO {

    private int id;
    private String position;
    private boolean currentlyEmployed;
    private String positive;
    private String negative;
    private String projects;
    private double grade;
    private LevelOfExperience levelOfExperience;
    private Engagement engagement;
    private String title;

    public CommentDTO() {}

    public CommentDTO(int id, String position, boolean currentlyEmployed, String positive, String negative, String projects, double grade, LevelOfExperience levelOfExperience, Engagement engagement, String title) {
        this.id = id;
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

    public CommentDTO(Comment comment) {
        this.id = comment.getId();
        this.position = comment.getPosition();
        this.currentlyEmployed = comment.isCurrentlyEmployed();
        this.positive = comment.getPositive();
        this.negative = comment.getNegative();
        this.projects = comment.getProjects();
        this.grade = comment.getGrade();
        this.levelOfExperience = comment.getLevelOfExperience();
        this.engagement = comment.getEngagement();
        this.title = comment.getTitle();
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
