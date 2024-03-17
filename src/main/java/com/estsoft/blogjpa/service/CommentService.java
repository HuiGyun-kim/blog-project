package com.estsoft.blogjpa.service;

import com.estsoft.blogjpa.dto.AddCommentRequest;
import com.estsoft.blogjpa.dto.CommentResponse;
import com.estsoft.blogjpa.dto.CommentViewResponse;

public interface CommentService {
	CommentResponse createComment(Long articleId, AddCommentRequest request);
	CommentViewResponse getComment(Long articleId, Long commentId);
}
