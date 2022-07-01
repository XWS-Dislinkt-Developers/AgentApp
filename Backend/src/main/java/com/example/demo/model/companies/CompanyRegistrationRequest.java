package com.example.demo.model.companies;

import com.example.demo.dto.companies.CompanyRequestDTO;
import com.example.demo.model.users.User;

import javax.persistence.*;
import java.util.List;

@Entity
public class CompanyRegistrationRequest {

    @Id
    @SequenceGenerator(name = "companyReqSeqGen", sequenceName = "companyReqSeqGen", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "companyReqSeqGen")
    @Column(name="id", unique=true, nullable=false)
    private int id;
    @Column
    private String name;
    @Column
    private String yearOfOpening;
    @ElementCollection(fetch = FetchType.LAZY)
    @Column
    private List<String> offices;
    @ElementCollection(fetch = FetchType.LAZY)
    @Column
    private List<String> positions;
    @Column
    private String description;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private User companyOwner;
    @Column
    private String numberOfEmployees;

    public CompanyRegistrationRequest() {}

    public CompanyRegistrationRequest(String name, String yearOfOpening, List<String> offices, String description, User companyOwner, List<String> positions, String numberOfEmployees) {
        this.name = name;
        this.yearOfOpening = yearOfOpening;
        this.offices = offices;
        this.description = description;
        this.companyOwner = companyOwner;
        this.positions = positions;
        this.numberOfEmployees = numberOfEmployees;
    }

    public CompanyRegistrationRequest(CompanyRequestDTO companyRequestDTO, User user) {
        this.name = companyRequestDTO.getName();
        this.yearOfOpening = companyRequestDTO.getYearOfOpening();
        this.offices = companyRequestDTO.getOffices();
        this.description = companyRequestDTO.getDescription();
        this.companyOwner = user;
        this.numberOfEmployees = companyRequestDTO.getNumberOfEmployees();
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

    public String getYearOfOpening() {
        return yearOfOpening;
    }

    public void setYearOfOpening(String yearOfOpening) {
        this.yearOfOpening = yearOfOpening;
    }

    public List<String> getOffices() {
        return offices;
    }

    public void setOffices(List<String> offices) {
        this.offices = offices;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getCompanyOwner() {
        return companyOwner;
    }

    public void setCompanyOwner(User companyOwner) {
        this.companyOwner = companyOwner;
    }

    public List<String> getPositions() {
        return positions;
    }

    public void setPositions(List<String> positions) {
        this.positions = positions;
    }

    public String getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(String numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }
}
