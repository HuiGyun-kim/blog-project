package com.estsoft.blogjpa.dto;

import com.estsoft.blogjpa.model.Article;
import com.estsoft.blogjpa.model.Comment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentResponse {
    private long articleId;
    private String body;

    public CommentResponse(Comment Comment) {
        articleId = Comment.getArticle().getId(); //ID를 얻기 위해 getter 사용
        body = Comment.getBody();
    }
}
