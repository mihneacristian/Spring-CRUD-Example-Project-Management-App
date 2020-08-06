package com.mihneacristian.project_tracker.Entities;

import javax.persistence.*;

@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    Integer commentId;

    @Column(name = "text")
    String text;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "item_id")
    Item itemIdForThisComment;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Item getItemIdForThisComment() {
        return itemIdForThisComment;
    }

    public void setItemIdForThisComment(Item itemIdForThisComment) {
        this.itemIdForThisComment = itemIdForThisComment;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", text='" + text + '\'' +
                ", itemIdForThisComment=" + itemIdForThisComment +
                '}';
    }
}
