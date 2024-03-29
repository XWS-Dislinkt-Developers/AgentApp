package com.example.demo.controller.companies;

import com.example.demo.dto.companies.*;
import com.example.demo.model.companies.Company;
import com.example.demo.model.users.User;
import com.example.demo.service.companies.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "company")
@Controller
public class CompanyController {

    private CompanyService companyService;

    public CompanyController(CompanyService companyService){
        this.companyService = companyService;
    }

    @PostMapping(value = "/searchName")
    public ResponseEntity<List<CompanyDTO>> getCompanies(@RequestBody String search){
        ArrayList<CompanyDTO> ret = new ArrayList<>();

        for (Company company : this.companyService.getCompanies(search)){
            ret.add(new CompanyDTO(company.getId(), company.getName(), company.getYearOfOpening(), company.getDescription(), company.getOffices(), Math.round(company.getGrade()*100.0)/100.0, company.getLogoImage(), company.getNumberOfEmployees()));
        }

        return new ResponseEntity<>(ret, HttpStatus.OK);
    }

    @PostMapping(value = "/searchNameAndOffice")
    public ResponseEntity<List<CompanyDTO>> getCompaniesFullSearch(@RequestBody CompanySearchDTO search){
        ArrayList<CompanyDTO> ret = new ArrayList<>();

        for (Company company : this.companyService.getCompaniesFullSearch(search.getSearchParam())){
            ret.add(new CompanyDTO(company.getId(), company.getName(), company.getYearOfOpening(), company.getDescription(), company.getOffices(), Math.round(company.getGrade()*100.0)/100.0, company.getLogoImage(), company.getNumberOfEmployees()));
        }

        return new ResponseEntity<>(ret, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CompanyDTO> getCompany(@PathVariable int id){
        Company company = this.companyService.getCompany(id);
        return new ResponseEntity<>(new CompanyDTO(company.getId(), company.getName(), company.getYearOfOpening(), company.getDescription(), company.getOffices(), Math.round(company.getGrade()*100.0)/100.0, company.getLogoImage(), company.getNumberOfEmployees()), HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('COMPANY_OWNER')")
    @PutMapping(value = "/changeCompany")
    public ResponseEntity<CompanyDTO> changeCompany(@RequestBody CompanyChangeDTO companyDTO){
        Company company = this.companyService.changeCompany(companyDTO);
        return new ResponseEntity<>(new CompanyDTO(company.getId(), company.getName(), company.getYearOfOpening(), company.getDescription(), company.getOffices(), Math.round(company.getGrade()*100.0)/100.0, company.getLogoImage(), company.getNumberOfEmployees()), HttpStatus.OK);
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity<List<CompanyDTO>> getAll(){
        ArrayList<CompanyDTO> ret = new ArrayList<>();

        for (Company company : this.companyService.findAll()){
            ret.add(new CompanyDTO(company.getId(), company.getName(), company.getYearOfOpening(), company.getDescription(), company.getOffices(), Math.round(company.getGrade()*100.0)/100.0, company.getLogoImage(), company.getNumberOfEmployees()));
        }

        return new ResponseEntity<>(ret, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('COMPANY_OWNER')")
    @GetMapping(value = "/getMyCompany")
    public ResponseEntity<CompanyDTO> getCompany(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User)authentication.getPrincipal();
        Company company = this.companyService.getCompanyForUser(user);
        return new ResponseEntity<>(new CompanyDTO(company.getId(), company.getName(), company.getYearOfOpening(), company.getDescription(), company.getOffices(), Math.round(company.getGrade()*100.0)/100.0, company.getLogoImage(), company.getNumberOfEmployees()), HttpStatus.OK);
    }


}
