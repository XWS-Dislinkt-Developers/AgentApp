package com.example.demo.service.jobOffers;

import com.example.demo.model.companies.Company;
import com.example.demo.model.jobOffers.SalaryAndBenefits;
import com.example.demo.repository.jobOffers.SalaryAndBenefitsRepository;
import com.example.demo.service.companies.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaryAndBenefitsService {

    private SalaryAndBenefitsRepository salaryAndBenefitsRepository;
    private CompanyService companyService;

    public SalaryAndBenefitsService(SalaryAndBenefitsRepository salaryAndBenefitsRepository, CompanyService companyService){
        this.salaryAndBenefitsRepository = salaryAndBenefitsRepository;
        this.companyService = companyService;
    }

    public void save(SalaryAndBenefits salaryAndBenefits, int companyId){
        Company company = this.companyService.getCompany(companyId);
        salaryAndBenefits.setCompany(company);
        this.salaryAndBenefitsRepository.save(salaryAndBenefits);
    }

    public List<SalaryAndBenefits> getSalaryAndBenefitsForCompany(int companyId){
        return this.salaryAndBenefitsRepository.getSalaryAndBenefitsForCompany(companyId);
    }

}
