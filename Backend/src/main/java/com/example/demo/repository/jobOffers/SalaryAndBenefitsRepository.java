package com.example.demo.repository.jobOffers;

import com.example.demo.model.jobOffers.SalaryAndBenefits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalaryAndBenefitsRepository extends JpaRepository<SalaryAndBenefits, Integer> {
    @Query(value = "select distinct s from SalaryAndBenefits s join fetch s.company c join fetch s.benefits where c.id = ?1")
    List<SalaryAndBenefits> getSalaryAndBenefitsForCompany(int id);
}
