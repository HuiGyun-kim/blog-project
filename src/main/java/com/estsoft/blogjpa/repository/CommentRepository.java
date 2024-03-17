package com.estsoft.blogjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.estsoft.blogjpa.model.Article;
import com.estsoft.blogjpa.model.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
