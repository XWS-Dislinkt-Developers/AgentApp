package com.example.demo.model.companies;

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
    @ElementCollection
    @Column
    private List<String> offices;
    @Column
    private String description;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE )
    private User companyOwner;

    public CompanyRegistrationRequest() {}

    public CompanyRegistrationRequest(String name, String yearOfOpening, List<String> offices, String description, User companyOwner) {
        this.name = name;
        this.yearOfOpening = yearOfOpening;
        this.offices = offices;
        this.description = description;
        this.companyOwner = companyOwner;
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
}
