package com.example.forum.repository.repositoryInterfaces;

import com.example.forum.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUsername(String username);
}
