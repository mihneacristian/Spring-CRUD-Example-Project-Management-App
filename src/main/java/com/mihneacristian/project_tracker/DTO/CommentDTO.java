package com.mihneacristian.project_tracker.DTO;

public class CommentDTO {

    public int commentId;
    public String text;

    public CommentDTO() {
    }

    public CommentDTO(int commentId, String text) {
        this.commentId = commentId;
        this.text = text;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "CommentDTO{" +
                "commentId=" + commentId +
                ", text='" + text + '\'' +
                '}';
    }
}
