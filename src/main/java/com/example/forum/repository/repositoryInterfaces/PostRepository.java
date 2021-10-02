package com.example.forum.repository.repositoryInterfaces;

import com.example.forum.model.Post;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends CrudRepository<Post, Integer> {
    @EntityGraph(attributePaths = {"user"})
    List<Post> findAll();

    @EntityGraph(attributePaths = {"user", "comments"})
    Optional<Post> findById(int id);
}