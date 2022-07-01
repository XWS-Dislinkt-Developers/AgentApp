package com.example.demo.service.jobOffers;

import com.example.demo.dto.jobOffers.CommentNewDTO;
import com.example.demo.model.companies.Company;
import com.example.demo.model.jobOffers.Comment;
import com.example.demo.repository.jobOffers.CommentRepository;
import com.example.demo.service.companies.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    private CommentRepository commentRepository;
    private CompanyService companyService;

    public CommentService(CommentRepository commentRepository, CompanyService companyService){
        this.commentRepository = commentRepository;
        this.companyService = companyService;
    }

    public void save(CommentNewDTO comment){
        Company company = this.companyService.getCompany(comment.getCompanyId());
        this.commentRepository.save(new Comment(company, comment.getPosition(), comment.isCurrentlyEmployed(), comment.getPositive(), comment.getNegative(), comment.getProjects(), comment.getGrade(), comment.getLevelOfExperience(), comment.getEngagement(), comment.getTitle()));
        this.updateGrade(company);
    }

    private void updateGrade(Company company) {
        double sum = 0;
        double br = 0;
        double grade = 0;
        for (Comment comment : this.commentRepository.commentsForCompany(company.getId())){
            sum = sum + comment.getGrade();
            br = br + 1;
        }
        grade = sum / br;
        company.setGrade(grade);
        this.companyService.save(company);
    }

    public List<Comment> commentsForCompany(int id){
        return this.commentRepository.commentsForCompany(id);
    }

}
