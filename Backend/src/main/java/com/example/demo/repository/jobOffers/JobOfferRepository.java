package com.example.demo.repository.jobOffers;

import com.example.demo.model.jobOffers.JobOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobOfferRepository extends JpaRepository<JobOffer, Integer> {
}
