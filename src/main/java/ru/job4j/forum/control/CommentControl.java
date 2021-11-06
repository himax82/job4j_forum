package ru.job4j.forum.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.forum.model.Comment;
import ru.job4j.forum.repository.ForumMem;

@Controller
public class CommentControl {

    private final ForumMem mem;

    public CommentControl(ForumMem mem) {
        this.mem = mem;
    }

    @PostMapping("/comment/save")
    public String save(@RequestParam int postId, String text) {
        mem.saveComment(Comment.of(text, mem.findByUsername("user")), postId);
        return "redirect:/post?id=" + postId;
    }
}
