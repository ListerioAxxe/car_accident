package com.example.forum.controller;
import com.example.forum.model.Comment;
import com.example.forum.model.User;
import com.example.forum.service.CommentService;
import com.example.forum.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class CommentController {
    private final CommentService commentService;
    private final UserService userService;

    public CommentController(CommentService commentService, UserService userService) {
        this.commentService = commentService;
        this.userService = userService;
    }

    @PostMapping("/comment/save")
    public String save(@ModelAttribute Comment comment, RedirectAttributes attributes) {
        String username = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();
        User curUser = userService.findByUsername(username);
        comment.setUser(curUser);
        commentService.save(comment);
        attributes.addAttribute("id", comment.getPost().getId());
        return "redirect:/post/view";
    }
}
