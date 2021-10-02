package com.example.forum.service;

import com.example.forum.model.Authority;
import com.example.forum.repository.repositoryInterfaces.AuthorityRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthorityService {
    private final AuthorityRepository authorityRepository;

    public AuthorityService(AuthorityRepository authorityRepository) {
        this.authorityRepository = authorityRepository;
    }

    public Authority findByAuthority(String authority) {
        return authorityRepository.findByAuthority(authority);
    }
}