package com.estsoft.blogjpa.dto;

import java.time.LocalDateTime;

import com.estsoft.blogjpa.model.Comment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentViewResponse {
    private Long id;
    private long articleId;
    private String body;
    private LocalDateTime createdAt;

    public CommentViewResponse(Comment comment) {
        this.id = comment.getId();
        this.articleId = comment.getArticle().getId();
        this.body = comment.getBody();
        this.createdAt = comment.getCreatedAt();
    }
}
