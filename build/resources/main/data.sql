INSERT INTO article (title, content, created_at, updated_at) VALUES ('제목1', '내용1', NOW(), NOW());
INSERT INTO article (title, content, created_at, updated_at) VALUES ('제목2', '내용2', NOW(), NOW());
INSERT INTO article (title, content, created_at, updated_at) VALUES ('제목3', '내용3', NOW(), NOW());
INSERT INTO comment (article_id, body, created_at) VALUES (1, '댓글 내용1', NOW());
INSERT INTO comment (article_id, body, created_at) VALUES (1, '댓글 내용2', NOW());
INSERT INTO comment (article_id, body, created_at) VALUES (2, '댓글 내용3', NOW());