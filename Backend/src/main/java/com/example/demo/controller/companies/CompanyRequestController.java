package com.example.demo.controller.companies;

import com.example.demo.dto.companies.CompanyRequestDTO;
import com.example.demo.dto.companies.CompanyRequestViewDTO;
import com.example.demo.model.companies.CompanyRegistrationRequest;
import com.example.demo.model.users.User;
import com.example.demo.service.companies.CompanyRequestService;
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
@Controller
@RequestMapping(value = "companyRequest")
public class CompanyRequestController {

    private CompanyRequestService companyRequestService;

    public CompanyRequestController(CompanyRequestService companyRequestService){
        this.companyRequestService = companyRequestService;
    }

    @PreAuthorize("hasAnyRole('USER')")
    @RequestMapping(method = {RequestMethod.POST })
    public ResponseEntity<HttpStatus> save(@RequestBody CompanyRequestDTO companyRequestDTO){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User)authentication.getPrincipal();
        this.companyRequestService.save(new CompanyRegistrationRequest(companyRequestDTO, user));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping(value = "getAll")
    public ResponseEntity<List<CompanyRequestViewDTO>> getAll(){
        ArrayList<CompanyRequestViewDTO> ret = new ArrayList<>();

        for (CompanyRegistrationRequest request : this.companyRequestService.getAll()){
            ret.add(new CompanyRequestViewDTO(request.getId(),request.getName(), request.getYearOfOpening(),request.getDescription(), request.getNumberOfEmployees(), request.getCompanyOwner()));
        }

        return new ResponseEntity<>(ret, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping(value = "approveRequest")
    public ResponseEntity<HttpStatus> approveRequest(@RequestBody int id){
        this.companyRequestService.approveRequest(id);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
