package com.estsoft.blogjpa.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estsoft.blogjpa.dto.AddCommentRequest;
import com.estsoft.blogjpa.dto.CommentResponse;
import com.estsoft.blogjpa.dto.CommentViewResponse;
import com.estsoft.blogjpa.service.CommentService;

@RestController
@RequestMapping("/comments")
public class CommentController {
	private final CommentService commentService;

	// CommentService 주입
	public CommentController(CommentService commentService) {
		this.commentService = commentService;
	}

	// 댓글 생성 API
	@PostMapping("/{articleId}")
	public ResponseEntity<CommentResponse> createComment(@PathVariable Long articleId, @RequestBody AddCommentRequest request) {
		CommentResponse response = commentService.createComment(articleId, request);
		return ResponseEntity.ok(response);
	}

	// 댓글 조회 API
	@GetMapping("/{articleId}/{commentId}")
	public ResponseEntity<CommentViewResponse> getComment(@PathVariable Long articleId, @PathVariable Long commentId) {
		CommentViewResponse response = commentService.getComment(articleId, commentId);
		return ResponseEntity.ok(response);
	}
}
