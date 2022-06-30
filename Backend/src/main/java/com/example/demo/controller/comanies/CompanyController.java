package com.example.demo.controller.comanies;

import com.example.demo.dto.companies.*;
import com.example.demo.model.companies.Company;
import com.example.demo.model.companies.CompanyRegistrationRequest;
import com.example.demo.service.companies.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
    public ResponseEntity<List<CompanyDTO>> getCompanies(@RequestBody CompanySearchNameDTO search){
        ArrayList<CompanyDTO> ret = new ArrayList<>();

        for (Company company : this.companyService.getCompanies(search.getName())){
            ret.add(new CompanyDTO(company.getId(), company.getName(), company.getYearOfOpening(), company.getDescription(), company.getOffices(), company.getGrade(), company.getLogoImage()));
        }

        return new ResponseEntity<List<CompanyDTO>>(ret, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CompanyDTO> getCompany(@PathVariable int id){
        Company company = this.companyService.getCompany(id);
        return new ResponseEntity<CompanyDTO>(new CompanyDTO(company.getId(), company.getName(), company.getYearOfOpening(), company.getDescription(), company.getOffices(), company.getGrade(), company.getLogoImage()), HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('COMPANY_OWNER')")
    @PutMapping(value = "/changeCompany")
    public ResponseEntity<CompanyDTO> changeCompany(@RequestBody CompanyChangeDTO companyDTO){
        Company company = this.companyService.changeCompany(companyDTO);
        return new ResponseEntity<CompanyDTO>(new CompanyDTO(company.getId(), company.getName(), company.getYearOfOpening(), company.getDescription(), company.getOffices(), company.getGrade(), company.getLogoImage()), HttpStatus.OK);
    }
}
