package com.example.demo.model.jobOffers;

import com.example.demo.enums.LevelOfExperience;
import com.example.demo.model.companies.Company;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class JobOffer {

    @Id
    @SequenceGenerator(name = "jobOfferSeqGen", sequenceName = "jobOfferSeqGen", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jobOfferSeqGen")
    @Column(name="id", unique=true, nullable=false)
    private int id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    @JsonIgnoreProperties("jobOffers")
    private Company company;
    @Column
    private String position;
    @Column
    private LevelOfExperience levelOfExperience;
    @Column
    private String jobDescription;
    @Column
    private String dailyActivities;
    @Column
    private String requirements;
    @Column
    private Boolean promoteOnDislinkt;
    @Column
    @ElementCollection
    private List<String> benefits;
    @Column
    private Date expires;

    public JobOffer() {}

    public JobOffer(Company company, String position, LevelOfExperience levelOfExperience, String jobDescription, String dailyActivities, String requirements, Boolean promoteOnDislinkt, List<String> benefits, Date expires) {
        this.company = company;
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
