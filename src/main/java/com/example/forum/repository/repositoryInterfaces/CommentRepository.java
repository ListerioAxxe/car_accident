package com.example.forum.repository.repositoryInterfaces;

import com.example.forum.model.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Integer> { }
