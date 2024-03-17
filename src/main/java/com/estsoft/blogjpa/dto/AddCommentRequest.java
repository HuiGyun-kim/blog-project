package com.estsoft.blogjpa.dto;

import com.estsoft.blogjpa.model.Article;
import com.estsoft.blogjpa.model.Comment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddCommentRequest {
    private long articleId;
    private String body;

    public Comment toEntity(Article article) {	// Article 엔티티 참조를 파라미터로 받음
        return Comment.builder()
                .article(article)// Article 객체를 넘김
                .body(body)
                .build();
    }
}
