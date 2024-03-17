package com.estsoft.blogjpa.model;

import com.estsoft.blogjpa.dto.ArticleResponse;
import com.estsoft.blogjpa.dto.ArticleViewResponse;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    // Article과 Comment의 1:N 관계를 매핑합니다.
    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Comment> comments = new ArrayList<>();

    @Builder
    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Article() {
    }

    public ArticleResponse toResponse() {
        return ArticleResponse.builder()
                .title(title)
                .content(content)
                .build();
    }

    public ArticleViewResponse toViewResponse() {
        return new ArticleViewResponse(id, title, content, createdAt, updatedAt);
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
    // Comment 엔티티를 추가하는 편의 메소드
    public void addComment(Comment comment) {
        comments.add(comment);
        comment.setArticle(this);
    }
}
