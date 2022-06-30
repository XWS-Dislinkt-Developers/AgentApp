package com.example.demo.model.jobOffers;

import com.example.demo.enums.Engagement;
import com.example.demo.enums.LevelOfExperience;
import com.example.demo.model.companies.Company;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
public class Comment {

    @Id
    @SequenceGenerator(name = "commentSeqGen", sequenceName = "commentSeqGen", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "commentSeqGen")
    @Column(name="id", unique=true, nullable=false)
    private int id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    @JsonIgnoreProperties("comments")
    private Company company;
    @Column
    private String position;
    @Column
    private boolean currentlyEmployed;
    @Column
    private String positive;
    @Column
    private String negative;
    @Column
    private String projects;
    @Column
    private double grade;
    @Column
    private LevelOfExperience levelOfExperience;
    @Column
    private Engagement engagement;
    @Column
    private String title;

    public Comment() {}

    public Comment(Company company, String position, boolean currentlyEmployed, String positive, String negative, String projects, double grade, LevelOfExperience levelOfExperience, Engagement engagement, String title) {
        this.company = company;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
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
