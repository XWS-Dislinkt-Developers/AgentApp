package com.example.demo.controller.jobOffers;

import com.example.demo.dto.jobOffers.InterviewDTO;
import com.example.demo.dto.jobOffers.InterviewNewDTO;
import com.example.demo.model.jobOffers.Interview;
import com.example.demo.service.jobOffers.InterviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "interview")
@Controller
public class InterviewController {

    private InterviewService interviewService;

    public InterviewController(InterviewService interviewService){
        this.interviewService = interviewService;
    }

    @GetMapping(value = "/getForCompany/{id}")
    public ResponseEntity<List<InterviewDTO>> getInterviewForCompany(@PathVariable int id){
        ArrayList<InterviewDTO> ret = new ArrayList<>();
        for(Interview interview : this.interviewService.getInterviewsForCompany(id)){
            ret.add(new InterviewDTO(interview));
        }
        return new ResponseEntity<List<InterviewDTO>>(ret, HttpStatus.OK);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<HttpStatus> save(@RequestBody InterviewNewDTO interviewNewDTO){
        this.interviewService.save(new Interview(interviewNewDTO.getYearOfInterview(), interviewNewDTO.getPosition(), interviewNewDTO.getHRInterview(), interviewNewDTO.getTechnicalInterview(), interviewNewDTO.getTitle(), interviewNewDTO.getInterviewDifficulty(), interviewNewDTO.getOfferStatus()), interviewNewDTO.getIdCompany());
        return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
    }

}
