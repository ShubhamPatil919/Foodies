package com.food.controller;

import com.food.entity.Admin;
import com.food.exception.Message;
import com.food.repo.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class HomeController {


    @Autowired
    private AdminRepo adminRepo;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/loginMain")
    public String login(Model model) {

        model.addAttribute("admin", new Admin());
        return "login";
    }

    @GetMapping("/signup")
    public String signUp(Model model){

        model.addAttribute("title","Sign Up");
        model.addAttribute("admin",new Admin());
        return "register";
    }

    @PostMapping(value = "/do_register")
    public String registerUser(@ModelAttribute("admin") Admin admin,
                               Model model,
                               HttpSession session) {

admin.setPassword(passwordEncoder.encode(admin.getPassword()));
admin.setRole("ROLE_ADMIN");

Admin results=adminRepo.save(admin);
        model.addAttribute("admin",new Admin());
        session.setAttribute("message", new Message("Successfully Register!", "alert-success"));
        return"login";
    }





    @GetMapping("/dash")
    public String dashborad(Model model) {
        model.addAttribute("admin", new Admin());
        return "add_menu";
    }

}
