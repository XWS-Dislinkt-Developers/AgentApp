package com.example.demo.dto.jobOffers;

import com.example.demo.enums.InterviewDifficulty;
import com.example.demo.enums.OfferStatus;
import com.example.demo.model.jobOffers.Interview;

public class InterviewDTO {

    private int id;
    private String yearOfInterview;
    private String position;
    private String HRInterview;
    private String technicalInterview;
    private String title;
    private InterviewDifficulty interviewDifficulty;
    private OfferStatus offerStatus;

    public InterviewDTO() {}

    public InterviewDTO(int id, String yearOfInterview, String position, String HRInterview, String technicalInterview, String title, InterviewDifficulty interviewDifficulty, OfferStatus offerStatus) {
        this.id = id;
        this.yearOfInterview = yearOfInterview;
        this.position = position;
        this.HRInterview = HRInterview;
        this.technicalInterview = technicalInterview;
        this.title = title;
        this.interviewDifficulty = interviewDifficulty;
        this.offerStatus = offerStatus;
    }

    public InterviewDTO(Interview interview) {
        this.id = interview.getId();
        this.yearOfInterview = interview.getYearOfInterview();
        this.position = interview.getPosition();
        this.HRInterview = interview.getHRInterview();
        this.technicalInterview = interview.getTechnicalInterview();
        this.title = interview.getTitle();
        this.interviewDifficulty = interview.getInterviewDifficulty();
        this.offerStatus = interview.getOfferStatus();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
