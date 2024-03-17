package com.estsoft.blogjpa.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.estsoft.blogjpa.dto.ArticleResponse;
import com.estsoft.blogjpa.dto.ArticleViewResponse;
import com.estsoft.blogjpa.dto.CommentResponse;
import com.estsoft.blogjpa.dto.CommentViewResponse;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;

@Getter
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @JoinColumn(name = "article_id", nullable = false)
    @ManyToOne
    private Article article;

    @Column(name = "body", nullable = false)
    private String body;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Builder
    public Comment(Article article, String body) {
        this.article = article;
        this.body = body;
    }

    public Comment() {
    }

    public CommentResponse toResponse() {
        return CommentResponse.builder()
            .articleId(article.getId())
            .body(body)
            .build();
    }

    public CommentViewResponse toViewResponse() {
        return new CommentViewResponse(id, article.getId(), body, createdAt);
    }

    public void setArticle(Article article) {
        this.article = article;

        // 양방향 관계 설정: Article 엔티티의 comments 컬렉션에 현재 Comment 인스턴스를 추가.
        // 이 부분은 양방향 관계를 유지하기 위해 필요하며, 순환 참조를 방지하기 위해 조건을 확인가능.
        if (!article.getComments().contains(this)) {
            article.getComments().add(this);
        }
    }
}