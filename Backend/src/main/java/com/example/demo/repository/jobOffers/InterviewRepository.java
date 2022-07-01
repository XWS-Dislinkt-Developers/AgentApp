package com.example.demo.repository.jobOffers;

import com.example.demo.model.jobOffers.Interview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InterviewRepository extends JpaRepository<Interview, Integer> {
    @Query(value = "select distinct i from Interview i join fetch i.company c where c.id = ?1")
    List<Interview> getInterviewsForCompany(int id);
}
