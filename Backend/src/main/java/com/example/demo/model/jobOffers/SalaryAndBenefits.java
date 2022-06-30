package com.example.demo.model.jobOffers;

import com.example.demo.enums.Engagement;
import com.example.demo.enums.LevelOfExperience;
import com.example.demo.model.companies.Company;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
public class SalaryAndBenefits {

    @Id
    @SequenceGenerator(name = "salarySeqGen", sequenceName = "salarySeqGen", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "salarySeqGen")
    @Column(name="id", unique=true, nullable=false)
    private int id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    @JsonIgnoreProperties("salaryAndBenefits")
    private Company company;
    @Column
    private String position;
    @Column
    private double salary;
    @ElementCollection
    @Column
    private List<String> benefits;
    @Column
    private LevelOfExperience levelOfExperience;
    @Column
    private Engagement engagement;

    public SalaryAndBenefits() {}

    public SalaryAndBenefits(Company company, String position, double salary, List<String> benefits, LevelOfExperience levelOfExperience, Engagement engagement) {
        this.company = company;
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
