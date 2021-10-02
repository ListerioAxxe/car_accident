package com.example.forum.service;

import com.example.forum.model.Comment;
import com.example.forum.repository.CommentRepository;
import com.example.forum.repository.PostRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    public CommentService(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    @Transactional
    public void save(Comment comment) {
        commentRepository.save(comment);
    }
}
