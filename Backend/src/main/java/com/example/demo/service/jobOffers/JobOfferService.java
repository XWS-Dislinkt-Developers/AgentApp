package com.example.demo.service.jobOffers;

import com.example.demo.model.companies.Company;
import com.example.demo.model.jobOffers.JobOffer;
import com.example.demo.model.users.User;
import com.example.demo.repository.companies.CompanyRepository;
import com.example.demo.repository.jobOffers.JobOfferRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobOfferService {

    private JobOfferRepository jobOfferRepository;
    private CompanyRepository companyRepository;

    public JobOfferService(JobOfferRepository jobOfferRepository, CompanyRepository companyRepository){
        this.jobOfferRepository = jobOfferRepository;
        this.companyRepository = companyRepository;
    }

    public List<JobOffer> getAll(){
        return this.jobOfferRepository.findAll();
    }

    public List<JobOffer> getJobOffersForCompany(int id){
        return this.jobOfferRepository.getJobOffersForCompany(id);
    }

    public void save(JobOffer jobOffer, User user) {
        Company company = this.companyRepository.findByOwner(user.getEmail());
        jobOffer.setCompany(company);
        this.jobOfferRepository.save(jobOffer);
    }

    public List<JobOffer> search(String param){
        return this.jobOfferRepository.searchJobOffers("%"+param+"%");
    }



}
