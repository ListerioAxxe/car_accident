package com.example.forum.service;

import com.example.forum.model.Post;
import com.example.forum.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public void save(Post post) {
        postRepository.save(post);
    }

    public void deleteById(int id) {
        postRepository.deleteById(id);
    }

    public List<Post> findAll() {
        List<Post> rsl = new ArrayList<>(postRepository.findAll());
        return rsl;
    }

    public Optional<Post> findById(int id) {
        return postRepository.findById(id);
    }
}
