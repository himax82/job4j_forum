package ru.job4j.forum.control;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.forum.model.Comment;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.service.CommentService;
import ru.job4j.forum.service.PostService;
import ru.job4j.forum.service.UserService;

@Controller
public class CommentControl {

    private final PostService postService;

    private final CommentService commentService;

    private final UserService userService;

    public CommentControl(PostService postService, CommentService commentService, UserService userService) {
            this.postService = postService;
            this.commentService = commentService;
            this.userService = userService;
        }

        @PostMapping("/comment/save")
        public String save(@RequestParam int postId, String text) {
            Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
            String username = loggedInUser.getName();
            Post post = postService.findPostById(postId);
            commentService.saveComment(Comment.of(text, post, userService.findByUsername(username)));
            return "redirect:/post?id=" + postId;
        }
    }
