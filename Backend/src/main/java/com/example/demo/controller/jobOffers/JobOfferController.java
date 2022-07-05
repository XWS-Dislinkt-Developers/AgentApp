package com.example.demo.controller.jobOffers;

import com.example.demo.dto.companies.CompanySearchDTO;
import com.example.demo.dto.jobOffers.JobOfferDTO;
import com.example.demo.dto.jobOffers.JobOffersViewDTO;
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
@CrossOrigin
@RequestMapping(value = "jobOffer")
@Controller
public class JobOfferController {

    private JobOfferService jobOfferService;

    public JobOfferController(JobOfferService jobOfferService){
        this.jobOfferService = jobOfferService;
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity<List<JobOffersViewDTO>> getAll(){
        ArrayList<JobOffersViewDTO> ret = new ArrayList<>();

        for (JobOffer jobOffer : this.jobOfferService.getJobOffersWithCompany()){
            ret.add(new JobOffersViewDTO(jobOffer.getId(),jobOffer.getPosition(), jobOffer.getLevelOfExperience(), jobOffer.getJobDescription(), jobOffer.getDailyActivities(), jobOffer.getRequirements(),  jobOffer.getBenefits(), jobOffer.getExpires(),jobOffer.getCompany().getLogoImage(), jobOffer.getCompany().getName(),  jobOffer.getCompany().getGrade()));
        }

        return new ResponseEntity<>(ret, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('COMPANY_OWNER')")
    @PostMapping(value = "/save")
    public ResponseEntity<HttpStatus> save(@RequestBody JobOfferDTO jobOfferDTO){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User)authentication.getPrincipal();
        this.jobOfferService.save(new JobOffer(jobOfferDTO), user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping(value = "/search")
    public ResponseEntity<List<JobOffersViewDTO>> search(@RequestBody String search){
        ArrayList<JobOffersViewDTO> ret = new ArrayList<>();

        for (JobOffer jobOffer : this.jobOfferService.search(search)){
            ret.add(new JobOffersViewDTO(jobOffer.getId(),jobOffer.getPosition(), jobOffer.getLevelOfExperience(), jobOffer.getJobDescription(), jobOffer.getDailyActivities(), jobOffer.getRequirements(),  jobOffer.getBenefits(), jobOffer.getExpires(),jobOffer.getCompany().getLogoImage(), jobOffer.getCompany().getName(),  jobOffer.getCompany().getGrade()));
        }

        return new ResponseEntity<>(ret, HttpStatus.OK);
    }

    @GetMapping(value = "/getForCompany/{id}")
    public ResponseEntity<List<JobOfferDTO>> getForCompany(@PathVariable int id){
        ArrayList<JobOfferDTO> ret = new ArrayList<>();

        for (JobOffer jobOffer : this.jobOfferService.getJobOffersForCompany(id)){
            ret.add(new JobOfferDTO(jobOffer.getPosition(), jobOffer.getLevelOfExperience(), jobOffer.getJobDescription(), jobOffer.getDailyActivities(), jobOffer.getRequirements(), jobOffer.getPromoteOnDislinkt(), jobOffer.getBenefits(), jobOffer.getExpires()));
        }

        return new ResponseEntity<>(ret, HttpStatus.OK);
    }
}
