package com.example.demo.repository.jobOffers;

import com.example.demo.model.jobOffers.SalaryAndBenefits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaryAndBenefitsRepository extends JpaRepository<SalaryAndBenefits, Integer> {
}
