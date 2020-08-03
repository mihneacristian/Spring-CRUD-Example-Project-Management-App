package com.mihneacristian.project_tracker.Services;

import com.mihneacristian.project_tracker.DTO.CommentDTO;
import com.mihneacristian.project_tracker.Entities.Comment;
import com.mihneacristian.project_tracker.Repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;

    @Transactional
    public Optional<Comment> getCommentById(Integer id) {

        return commentRepository.findByCommentId(id);
    }

    @Transactional
    public List<Comment> findByTextContains(String text) {

        return commentRepository.findByTextContains(text);
    }

    @Transactional
    public void saveNewComment(Comment commentText) {

        commentRepository.save(commentText);
    }

    @Transactional
    public List<CommentDTO> getAllComments() {

        List<Comment> allComments = commentRepository.findAll();
        List<CommentDTO> commentDTOS = new ArrayList<>();

        for (Comment comment :
                allComments) {
            CommentDTO temp = new CommentDTO();
            temp.commentId = comment.getCommentId();
            temp.text = comment.getText();
            commentDTOS.add(temp);
        }
        return commentDTOS;
    }

    @Transactional
    public void deleteCommentById(Integer id) {

        commentRepository.deleteById(id);
    }
}
