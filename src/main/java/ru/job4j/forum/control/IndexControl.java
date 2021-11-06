package ru.job4j.forum.control;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.job4j.forum.repository.ForumMem;

@Controller
public class IndexControl {

    private final ForumMem mem;

    public IndexControl(ForumMem mem) {
        this.mem = mem;
    }

    @GetMapping({"/", "/index"})
    public String index(Model model) {
        model.addAttribute("user", mem.findByUsername("user"));
        model.addAttribute("posts", mem.findAllPost());
        return "index";
    }
}