package com.example.demo.model.jobOffers;

import com.example.demo.enums.InterviewDifficulty;
import com.example.demo.enums.OfferStatus;
import com.example.demo.model.companies.Company;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
public class Interview {

    @Id
    @SequenceGenerator(name = "interviewSeqGen", sequenceName = "interviewSeqGen", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "interviewSeqGen")
    @Column(name="id", unique=true, nullable=false)
    private int id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    @JsonIgnoreProperties("interviews")
    private Company company;
    @Column
    private String yearOfInterview;
    @Column
    private String position;
    @Column
    private String HRInterview;
    @Column
    private String technicalInterview;
    @Column
    private String title;
    @Column
    private InterviewDifficulty interviewDifficulty;
    @Column
    private OfferStatus offerStatus;

    public Interview() {}

    public Interview(Company company, String yearOfInterview, String position, String HRInterview, String technicalInterview, String title, InterviewDifficulty interviewDifficulty, OfferStatus offerStatus) {
        this.company = company;
        this.yearOfInterview = yearOfInterview;
        this.position = position;
        this.HRInterview = HRInterview;
        this.technicalInterview = technicalInterview;
        this.title = title;
        this.interviewDifficulty = interviewDifficulty;
        this.offerStatus = offerStatus;
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

    public String getYearOfInterview() {
        return yearOfInterview;
    }

    public void setYearOfInterview(String yearOfInterview) {
        this.yearOfInterview = yearOfInterview;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getHRInterview() {
        return HRInterview;
    }

    public void setHRInterview(String HRInterview) {
        this.HRInterview = HRInterview;
    }

    public String getTechnicalInterview() {
        return technicalInterview;
    }

    public void setTechnicalInterview(String technicalInterview) {
        this.technicalInterview = technicalInterview;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public InterviewDifficulty getInterviewDifficulty() {
        return interviewDifficulty;
    }

    public void setInterviewDifficulty(InterviewDifficulty interviewDifficulty) {
        this.interviewDifficulty = interviewDifficulty;
    }

    public OfferStatus getOfferStatus() {
        return offerStatus;
    }

    public void setOfferStatus(OfferStatus offerStatus) {
        this.offerStatus = offerStatus;
    }
}
