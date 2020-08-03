package com.mihneacristian.project_tracker.EntityConverter;

import com.mihneacristian.project_tracker.DTO.CommentDTO;
import com.mihneacristian.project_tracker.Entities.Comment;

public class CommentEntityConverter implements EntityConverter<Comment, CommentDTO> {

    @Override
    public CommentDTO convertToDTO(Comment commentEntity) {
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.commentId = commentEntity.getCommentId();
        commentDTO.text = commentDTO.getText();
        return commentDTO;
    }

    @Override
    public Comment convertToEntity(CommentDTO commentDTO) {

        Comment commentEntity = new Comment();
        commentEntity.setText(commentDTO.text);
        return commentEntity;
    }
}
