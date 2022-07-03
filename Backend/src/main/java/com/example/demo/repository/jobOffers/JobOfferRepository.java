package com.example.demo.repository.jobOffers;

import com.example.demo.model.jobOffers.JobOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobOfferRepository extends JpaRepository<JobOffer, Integer> {
    @Query(value = "select distinct j from JobOffer j left join fetch j.benefits b")
    List<JobOffer> findAll();
    @Query(value = "select distinct j from JobOffer j left join fetch j.benefits b join fetch j.company c where c.id = ?1")
    List<JobOffer> getJobOffersForCompany(int id);
    @Query(value = "select distinct j from JobOffer j left join fetch j.benefits b join fetch j.company c where upper(c.name) like upper(?1) or upper(j.position) like upper(?1)")
    List<JobOffer> searchJobOffers(String param);
}
