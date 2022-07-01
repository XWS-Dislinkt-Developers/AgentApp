package com.example.demo.controller.jobOffers;

import com.example.demo.dto.jobOffers.SalaryAndBenefitsDTO;
import com.example.demo.dto.jobOffers.SalaryAndBenefitsNewDTO;
import com.example.demo.model.jobOffers.SalaryAndBenefits;
import com.example.demo.service.jobOffers.SalaryAndBenefitsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "salaryAndBenefits")
@Controller
public class SalaryAndBenefitsController {

    private SalaryAndBenefitsService salaryAndBenefitsService;

    public SalaryAndBenefitsController(SalaryAndBenefitsService salaryAndBenefitsService){
        this.salaryAndBenefitsService = salaryAndBenefitsService;
    }

    @PostMapping(value = "/save")
    public ResponseEntity<HttpStatus> save(@RequestBody SalaryAndBenefitsNewDTO salaryAndBenefitsNewDTO){
        this.salaryAndBenefitsService.save(new SalaryAndBenefits(salaryAndBenefitsNewDTO.getPosition(), salaryAndBenefitsNewDTO.getSalary(), salaryAndBenefitsNewDTO.getBenefits(), salaryAndBenefitsNewDTO.getLevelOfExperience(), salaryAndBenefitsNewDTO.getEngagement()), salaryAndBenefitsNewDTO.getCompanyId());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/getForCompany/{id}")
    public ResponseEntity<List<SalaryAndBenefitsDTO>> getForCompany(@PathVariable int id){
        ArrayList<SalaryAndBenefitsDTO> ret = new ArrayList<>();

        for (SalaryAndBenefits salaryAndBenefits : this.salaryAndBenefitsService.getSalaryAndBenefitsForCompany(id)){
            ret.add(new SalaryAndBenefitsDTO(salaryAndBenefits.getId(), salaryAndBenefits.getPosition(), salaryAndBenefits.getSalary(), salaryAndBenefits.getBenefits(), salaryAndBenefits.getLevelOfExperience(), salaryAndBenefits.getEngagement()));
        }

        return new ResponseEntity<>(ret, HttpStatus.OK);
    }
}
