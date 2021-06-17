package com.food.controller;

import com.food.entity.Admin;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("admin", new Admin());
        return "login";
    }

    @GetMapping("/signup")
    public void signUp(){}

    @GetMapping("/dash")
    public String dashborad(Model model) {
        model.addAttribute("admin", new Admin());
        return "add_menu";
    }

}
