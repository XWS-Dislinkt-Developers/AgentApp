package com.example.demo.controller.jobOffers;

import com.example.demo.dto.companies.CompanyDTO;
import com.example.demo.dto.companies.CompanySearchDTO;
import com.example.demo.dto.jobOffers.JobOfferDTO;
import com.example.demo.model.companies.Company;
import com.example.demo.model.jobOffers.JobOffer;
import com.example.demo.model.users.User;
import com.example.demo.service.jobOffers.JobOfferService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "jobOffer")
@Controller
public class JobOfferController {

    private JobOfferService jobOfferService;

    public JobOfferController(JobOfferService jobOfferService){
        this.jobOfferService = jobOfferService;
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity<List<JobOfferDTO>> getAll(){
        ArrayList<JobOfferDTO> ret = new ArrayList<>();

        for (JobOffer jobOffer : this.jobOfferService.getAll()){
            ret.add(new JobOfferDTO(jobOffer.getPosition(), jobOffer.getLevelOfExperience(), jobOffer.getJobDescription(), jobOffer.getDailyActivities(), jobOffer.getRequirements(), jobOffer.getPromoteOnDislinkt(), jobOffer.getBenefits(), jobOffer.getExpires()));
        }

        return new ResponseEntity<List<JobOfferDTO>>(ret, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('COMPANY_OWNER')")
    @PostMapping(value = "/save")
    public ResponseEntity<HttpStatus> save(@RequestBody JobOfferDTO jobOfferDTO){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User)authentication.getPrincipal();
        this.jobOfferService.save(new JobOffer(jobOfferDTO), user);
        return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
    }

    @PostMapping(value = "/search")
    public ResponseEntity<List<JobOfferDTO>> search(@RequestBody CompanySearchDTO search){
        ArrayList<JobOfferDTO> ret = new ArrayList<>();

        for (JobOffer jobOffer : this.jobOfferService.search(search.getSearchParam())){
            ret.add(new JobOfferDTO(jobOffer.getPosition(), jobOffer.getLevelOfExperience(), jobOffer.getJobDescription(), jobOffer.getDailyActivities(), jobOffer.getRequirements(), jobOffer.getPromoteOnDislinkt(), jobOffer.getBenefits(), jobOffer.getExpires()));
        }

        return new ResponseEntity<List<JobOfferDTO>>(ret, HttpStatus.OK);
    }

    @GetMapping(value = "/getForCompany/{id}")
    public ResponseEntity<List<JobOfferDTO>> getForCompany(@PathVariable int id){
        ArrayList<JobOfferDTO> ret = new ArrayList<>();

        for (JobOffer jobOffer : this.jobOfferService.getJobOffersForCompany(id)){
            ret.add(new JobOfferDTO(jobOffer.getPosition(), jobOffer.getLevelOfExperience(), jobOffer.getJobDescription(), jobOffer.getDailyActivities(), jobOffer.getRequirements(), jobOffer.getPromoteOnDislinkt(), jobOffer.getBenefits(), jobOffer.getExpires()));
        }

        return new ResponseEntity<List<JobOfferDTO>>(ret, HttpStatus.OK);
    }
}
