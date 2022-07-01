package com.example.demo.service.jobOffers;

import com.example.demo.model.companies.Company;
import com.example.demo.model.jobOffers.Interview;
import com.example.demo.repository.jobOffers.InterviewRepository;
import com.example.demo.service.companies.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterviewService {

    private InterviewRepository interviewRepository;
    private CompanyService companyService;

    public InterviewService(InterviewRepository interviewRepository, CompanyService companyService){
        this.interviewRepository = interviewRepository;
        this.companyService = companyService;
    }

    public void save(Interview interview, int companyId){
        Company company = this.companyService.getCompany(companyId);
        interview.setCompany(company);
        this.interviewRepository.save(interview);
    }

    public List<Interview> getInterviewsForCompany(int companyId){
        return this.interviewRepository.getInterviewsForCompany(companyId);
    }

}
