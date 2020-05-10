package com.mihneacristian.project_tracker.Repositories;

import com.mihneacristian.project_tracker.Entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
