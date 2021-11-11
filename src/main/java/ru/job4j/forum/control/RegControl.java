package ru.job4j.forum.control;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.job4j.forum.model.User;
import ru.job4j.forum.service.AuthorityService;
import ru.job4j.forum.service.UserService;

@Controller
public class RegControl {

    private final UserService userService;

    private final AuthorityService authorityService;

    private final PasswordEncoder encoder;

    public RegControl(UserService userService, AuthorityService authorityService, PasswordEncoder encoder) {
        this.userService = userService;
        this.authorityService = authorityService;
        this.encoder = encoder;
    }

    @PostMapping("/reg")
    public String regSave(@ModelAttribute User user, Model model) {
        if (userService.findByUsername(user.getUsername()) != null) {
            model.addAttribute("errorMessage", "Пользователь с таким именем уже существует!");
            return regPage();
        }
        user.setPassword(encoder.encode(user.getPassword()));
        user.setAuthority(authorityService.findByName("ROLE_USER"));
        user.setEnabled(true);
        userService.save(user);
        return "redirect:/login";
    }

    @GetMapping("/reg")
    public String regPage() {
        return "reg";
    }
}