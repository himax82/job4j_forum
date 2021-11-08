package ru.job4j.forum.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.forum.model.User;
import ru.job4j.forum.repository.ForumMem;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginControl {

    private final ForumMem mem;

    public LoginControl(ForumMem mem) {
        this.mem = mem;
    }

    @PostMapping("/login")
    public String regSave(@ModelAttribute User user, Model model) {
        if (mem.findByUsername(user.getUsername()) != null) {
                if (mem.findByUsername(user.getUsername()).getPassword().equals(user.getPassword())) {
                    model.addAttribute("user", user);
                    return "redirect:/post";
                }
            }
            model.addAttribute("errorMessage", "Такой пользователь уже существует!");
            return "/login";
        }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        return "redirect:/login?logout=true";
    }
}
