package com.example.demo.controller.jobOffers;

import com.example.demo.dto.jobOffers.CommentDTO;
import com.example.demo.dto.jobOffers.CommentNewDTO;
import com.example.demo.dto.jobOffers.JobOfferDTO;
import com.example.demo.model.jobOffers.Comment;
import com.example.demo.model.jobOffers.JobOffer;
import com.example.demo.model.users.User;
import com.example.demo.service.jobOffers.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "comment")
@Controller
public class CommentController {

    private CommentService commentService;

    public CommentController(CommentService commentService){
        this.commentService = commentService;
    }

    @PostMapping(value = "/save")
    public ResponseEntity<HttpStatus> save(@RequestBody CommentNewDTO commentNewDTO){
        this.commentService.save(commentNewDTO);
        return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/getComments/{id}")
    public ResponseEntity<List<CommentDTO>> getComments(@PathVariable int id){
        ArrayList<CommentDTO> ret = new ArrayList<>();

        for(Comment comment : this.commentService.commentsForCompany(id)){
            ret.add(new CommentDTO(comment));
        }

        return new ResponseEntity<List<CommentDTO>>(ret, HttpStatus.OK);
    }

}
