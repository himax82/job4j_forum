package ru.job4j.forum.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.job4j.forum.model.User;
import ru.job4j.forum.repository.ForumMem;

@Controller
public class RegControl {

    private final ForumMem mem;

    public RegControl(ForumMem mem) {
        this.mem = mem;
    }

    @PostMapping("/reg")
    public String regSave(@ModelAttribute User user, Model model) {
        if (mem.existsByUsername(user.getUsername())) {
            model.addAttribute("errorMessage", "Такой пользователь уже существует.");
            return regPage();
        }
        user.setAuthority(mem.findByName("ROLE_USER"));
        mem.save(user);
        return "redirect:/login";
    }

    @GetMapping("/reg")
    public String regPage() {
        return "reg";
    }
}