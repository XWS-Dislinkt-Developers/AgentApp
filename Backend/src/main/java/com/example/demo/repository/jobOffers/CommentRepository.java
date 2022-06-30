package com.example.demo.repository.jobOffers;

import com.example.demo.model.jobOffers.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
    @Query(value = "select c from Comment c join fetch c.company comp where comp.id = ?1")
    List<Comment> commentsForCompany(int id);
}
