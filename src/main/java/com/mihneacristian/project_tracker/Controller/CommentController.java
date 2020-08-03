package com.mihneacristian.project_tracker.Controller;

import com.mihneacristian.project_tracker.DTO.CommentDTO;
import com.mihneacristian.project_tracker.Entities.Comment;
import com.mihneacristian.project_tracker.Services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommentController {

    @Autowired
    CommentService commentService;

    @GetMapping(value = "/comments", produces = "application/json")
    public ResponseEntity<List<CommentDTO>> getAllComments() {

        List<CommentDTO> commentDTOS = commentService.getAllComments();
        return new ResponseEntity<List<CommentDTO>>(commentDTOS, HttpStatus.OK);
    }
}
