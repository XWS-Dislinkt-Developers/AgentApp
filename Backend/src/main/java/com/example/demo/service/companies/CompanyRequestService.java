package com.example.demo.service.companies;

import com.example.demo.model.companies.Company;
import com.example.demo.model.companies.CompanyRegistrationRequest;
import com.example.demo.model.users.User;
import com.example.demo.repository.companies.CompanyRepository;
import com.example.demo.repository.companies.CompanyRequestRepository;
import com.example.demo.service.users.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyRequestService {

    private CompanyRequestRepository companyRequestRepository;
    private CompanyRepository companyRepository;
    private UserService userService;

    public CompanyRequestService(CompanyRequestRepository companyRequestRepository, CompanyRepository companyRepository, UserService userService){
        this.companyRequestRepository = companyRequestRepository;
        this.companyRepository = companyRepository;
        this.userService = userService;
    }

    public CompanyRegistrationRequest save(CompanyRegistrationRequest companyRegistrationRequest){
        return this.companyRequestRepository.save(companyRegistrationRequest);
    }

    public List<CompanyRegistrationRequest> getAll(){
        return this.companyRequestRepository.findAll();
    }

    public void approveRequest(int id) {
        CompanyRegistrationRequest request = this.companyRequestRepository.findById(id);
        User user =  userService.setUserToCompanyOwner(request.getCompanyOwner());
        this.companyRepository.save(new Company(request.getName(), request.getYearOfOpening(), request.getOffices(), user, request.getDescription(), request.getPositions(), request.getNumberOfEmployees()));
        this.companyRequestRepository.delete(request);
    }

    public void declineRequest(int id) {
        CompanyRegistrationRequest request = this.companyRequestRepository.findById(id);
        this.companyRequestRepository.delete(request);
    }
}
