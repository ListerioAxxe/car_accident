package com.example.forum.controller;

import com.example.forum.model.User;
import com.example.forum.service.PostService;
import com.example.forum.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class IndexController {
    private final PostService posts;
    private final UserService userService;

    public IndexController(PostService posts, UserService userService) {
        this.posts = posts;
        this.userService = userService;
    }

    @GetMapping({"/", "/index"})
    public String index(Model model) {
        model.addAttribute("posts", posts.findAll());
        String username = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();
        User curUser = userService.findByUsername(username);
        model.addAttribute("userId", curUser.getId());
        return "index";
    }
}
