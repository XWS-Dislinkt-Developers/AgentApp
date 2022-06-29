package com.example.demo.service.companies;

import com.example.demo.model.companies.Company;
import com.example.demo.model.companies.CompanyRegistrationRequest;
import com.example.demo.repository.companies.CompanyRepository;
import com.example.demo.repository.companies.CompanyRequestRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyRequestService {

    private CompanyRequestRepository companyRequestRepository;
    private CompanyRepository companyRepository;

    public CompanyRequestService(CompanyRequestRepository companyRequestRepository, CompanyRepository companyRepository){
        this.companyRequestRepository = companyRequestRepository;
        this.companyRepository = companyRepository;
    }

    public CompanyRegistrationRequest save(CompanyRegistrationRequest companyRegistrationRequest){
        return this.companyRequestRepository.save(companyRegistrationRequest);
    }

    public List<CompanyRegistrationRequest> getAll(){
        return this.companyRequestRepository.findAll();
    }

    public void approveRequest(int id) {
        CompanyRegistrationRequest request = this.companyRequestRepository.findById(id);
        this.companyRepository.save(new Company(request.getName(), request.getYearOfOpening(), request.getOffices(), request.getCompanyOwner(), request.getDescription(), request.getPositions()));
        this.companyRequestRepository.delete(request);
    }
}
