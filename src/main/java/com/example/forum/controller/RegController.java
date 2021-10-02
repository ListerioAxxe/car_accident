package com.example.forum.controller;

import com.example.forum.model.User;
import com.example.forum.service.AuthorityService;
import com.example.forum.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegController {
    private final PasswordEncoder encoder;
    private final UserService userService;
    private final AuthorityService authorityService;

    public RegController(
            PasswordEncoder encoder,
            UserService userService,
            AuthorityService authorityService
    ) {
        this.encoder = encoder;
        this.userService = userService;
        this.authorityService = authorityService;
    }

    @PostMapping("/reg")
    public String save(@ModelAttribute User user) {
        user.setEnabled(true);
        user.setPassword(encoder.encode(user.getPassword()));
        user.setAuthority(authorityService.findByAuthority("ROLE_USER"));
        userService.save(user);
        return "redirect:/login";
    }

    @GetMapping("/reg")
    public String reg() {
        return "reg";
    }
}
