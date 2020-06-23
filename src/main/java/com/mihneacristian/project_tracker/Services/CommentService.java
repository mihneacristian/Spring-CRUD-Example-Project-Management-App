package com.mihneacristian.project_tracker.Services;

import com.mihneacristian.project_tracker.Entities.Comment;
import com.mihneacristian.project_tracker.Repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
    public List<Comment> getAllComments() {

        return commentRepository.findAll();
    }

    @Transactional
    public void deleteCommentById(Integer id) {

        commentRepository.deleteById(id);
    }
}
