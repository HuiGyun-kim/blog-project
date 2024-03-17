package com.estsoft.blogjpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estsoft.blogjpa.dto.AddCommentRequest;
import com.estsoft.blogjpa.dto.CommentResponse;
import com.estsoft.blogjpa.dto.CommentViewResponse;
import com.estsoft.blogjpa.model.Article;
import com.estsoft.blogjpa.model.Comment;
import com.estsoft.blogjpa.repository.ArticleRepository;
import com.estsoft.blogjpa.repository.CommentRepository;

@Service
public class CommentServiceImpl implements CommentService {

		private final CommentRepository commentRepository;
		private final ArticleRepository articleRepository;

		@Autowired
		public CommentServiceImpl(CommentRepository commentRepository, ArticleRepository articleRepository) {
			this.commentRepository = commentRepository;
			this.articleRepository = articleRepository;
		}

		@Override
		public CommentResponse createComment(Long articleId, AddCommentRequest request) {
			// Article ID를 통해 Article 엔티티 조회
			Article article = articleRepository.findById(articleId)
				.orElseThrow(() -> new IllegalArgumentException("Article not found with id: " + articleId));

			// Comment 엔티티 생성 및 저장
			Comment comment = Comment.builder()
				.article(article)
				.body(request.getBody())
				.build();
			Comment savedComment = commentRepository.save(comment);

			// CommentResponse 반환
			return new CommentResponse(savedComment);
		}

		@Override
		public CommentViewResponse getComment(Long articleId, Long commentId) {
			// Comment ID를 통해 Comment 엔티티 조회
			Comment comment = commentRepository.findById(commentId)
				.orElseThrow(() -> new IllegalArgumentException("Comment not found with id: " + commentId));

			// CommentViewResponse 반환
			return new CommentViewResponse(comment);
		}
	}
