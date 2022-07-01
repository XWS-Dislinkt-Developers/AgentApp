package com.example.demo.dto.jobOffers;

import com.example.demo.enums.InterviewDifficulty;
import com.example.demo.enums.OfferStatus;

public class InterviewNewDTO {

    private int idCompany;
    private String yearOfInterview;
    private String position;
    private String HRInterview;
    private String technicalInterview;
    private String title;
    private InterviewDifficulty interviewDifficulty;
    private OfferStatus offerStatus;

    public InterviewNewDTO(){}

    public InterviewNewDTO(int idCompany, String yearOfInterview, String position, String HRInterview, String technicalInterview, String title, InterviewDifficulty interviewDifficulty, OfferStatus offerStatus) {
        this.idCompany = idCompany;
        this.yearOfInterview = yearOfInterview;
        this.position = position;
        this.HRInterview = HRInterview;
        this.technicalInterview = technicalInterview;
        this.title = title;
        this.interviewDifficulty = interviewDifficulty;
        this.offerStatus = offerStatus;
    }

    public int getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(int idCompany) {
        this.idCompany = idCompany;
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
