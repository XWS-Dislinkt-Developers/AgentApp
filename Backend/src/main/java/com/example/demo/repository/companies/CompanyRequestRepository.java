package com.example.demo.repository.companies;

import com.example.demo.model.companies.CompanyRegistrationRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRequestRepository extends JpaRepository<CompanyRegistrationRequest, Integer> {
     CompanyRegistrationRequest findById(int id);
}
