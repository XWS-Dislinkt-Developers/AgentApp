package com.example.demo.repository.companies;

import com.example.demo.model.companies.CompanyRegistrationRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRequestRepository extends JpaRepository<CompanyRegistrationRequest, Integer> {
     @Query(value = "select distinct r from CompanyRegistrationRequest r join fetch r.companyOwner o")
     CompanyRegistrationRequest findById(int id);
}
