package com.example.demo.model.companies;

import com.example.demo.model.jobOffers.Comment;
import com.example.demo.model.jobOffers.Interview;
import com.example.demo.model.jobOffers.JobOffer;
import com.example.demo.model.jobOffers.SalaryAndBenefits;
import com.example.demo.model.users.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Company {

    @Id
    @SequenceGenerator(name = "companySeqGen", sequenceName = "companySeqGen", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "companySeqGen")
    @Column(name="id", unique=true, nullable=false)
    private int id;
    @Column(nullable = false)
    private String name;
    @Column
    private Date yearOfOpening;
    @ElementCollection
    @Column
    private List<String> offices;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE )
    private User companyOwner;
    @Column
    private String description;
    @ElementCollection
    @Column
    private List<String> positions;
    @Column
    private double grade;
    @Column
    private String logoImage;
    @OneToMany(mappedBy= "company", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnoreProperties("company")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<JobOffer> jobOffers;
    @OneToMany(mappedBy= "company", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnoreProperties("company")
    private List<Comment> comments;
    @OneToMany(mappedBy= "company", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnoreProperties("company")
    private List<SalaryAndBenefits> salaryAndBenefits;
    @OneToMany(mappedBy= "company", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnoreProperties("company")
    private List<Interview> interviews;

    public Company() {}

    public Company(String name, Date yearOfOpening, List<String> offices, User companyOwner, String description, List<String> positions) {
        this.name = name;
        this.yearOfOpening = yearOfOpening;
        this.offices = offices;
        this.companyOwner = companyOwner;
        this.description = description;
        this.positions = positions;
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

    public Date getYearOfOpening() {
        return yearOfOpening;
    }

    public void setYearOfOpening(Date yearOfOpening) {
        this.yearOfOpening = yearOfOpening;
    }

    public List<String> getOffices() {
        return offices;
    }

    public void setOffices(List<String> offices) {
        this.offices = offices;
    }

    public User getCompanyOwner() {
        return companyOwner;
    }

    public void setCompanyOwner(User companyOwner) {
        this.companyOwner = companyOwner;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getPositions() {
        return positions;
    }

    public void setPositions(List<String> positions) {
        this.positions = positions;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public List<JobOffer> getJobOffers() {
        return jobOffers;
    }

    public void setJobOffers(List<JobOffer> jobOffers) {
        this.jobOffers = jobOffers;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<SalaryAndBenefits> getSalaryAndBenefits() {
        return salaryAndBenefits;
    }

    public void setSalaryAndBenefits(List<SalaryAndBenefits> salaryAndBenefits) { this.salaryAndBenefits = salaryAndBenefits; }

    public List<Interview> getInterviews() {
        return interviews;
    }

    public void setInterviews(List<Interview> interviews) {
        this.interviews = interviews;
    }

    public String getLogoImage() { return logoImage; }

    public void setLogoImage(String logoImage) { this.logoImage = logoImage; }
}
