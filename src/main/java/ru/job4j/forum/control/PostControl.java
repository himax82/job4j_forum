package ru.job4j.forum.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.forum.model.Authority;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.model.User;
import ru.job4j.forum.repository.ForumMem;

@Controller
public class PostControl {

    private final ForumMem mem;

    private User user = User.of("Vasya", "qwerty", Authority.of("User"));

    public PostControl(ForumMem mem) {
        this.mem = mem;
    }

    @GetMapping("/post")
    public String post(@RequestParam int id, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("post", mem.findPostById(id));
        return "post";
    }

    @GetMapping("/post/create")
    public String create(Model model) {
        model.addAttribute("user", user);
        return "post/create";
    }


    @GetMapping("/post/edit")
    public String edit(@RequestParam int id, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("post", mem.findPostById(id));
        return "post/edit";
    }

    @PostMapping("/post/save")
    public String save(@ModelAttribute Post post) {
        post.setAuthor(user);
        mem.savePost(post);
        return "redirect:/post?id=" + post.getId();
    }

    @PostMapping("/post/delete")
    public String delete(@RequestParam int id) {
        mem.deletePost(id);
        return "redirect:/index";
    }
}
