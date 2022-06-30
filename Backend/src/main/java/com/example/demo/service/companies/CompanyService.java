package com.example.demo.service.companies;

import com.example.demo.dto.companies.CompanyChangeDTO;
import com.example.demo.model.companies.Company;
import com.example.demo.repository.companies.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    private CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository){
        this.companyRepository = companyRepository;
    }

    public List<Company> getCompanies(String name) {
        return this.companyRepository.getCompanies(name);
    }

    public List<Company> getCompaniesFullSearch(String searchParam) {
        return this.companyRepository.getCompaniesFullSearch(searchParam);
    }

    public Company getCompany(int id) {
        return this.companyRepository.getCompany(id);
    }

    public Company changeCompany(CompanyChangeDTO companyDTO) {
        Company company = this.companyRepository.getCompany(companyDTO.getId());
        company.setName(companyDTO.getName());
        company.setDescription(companyDTO.getDescription());
        company.setLogoImage(companyDTO.getLogoImage());
        company.setOffices(companyDTO.getOffices());
        company.setPositions(companyDTO.getPositions());
        return this.companyRepository.save(company);
    }

    public List<Company> findAll() {
        return this.companyRepository.findAll();
    }
}
