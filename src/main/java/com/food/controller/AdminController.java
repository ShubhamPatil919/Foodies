package com.food.controller;

import com.food.entity.Admin;
import com.food.repo.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import java.security.Principal;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminRepo adminRepo;


    @ModelAttribute
    public void addCommon(Model model,Principal principal)
    {
        String username = principal.getName();
        Admin admin=adminRepo.getUserByEmail(username);
        System.out.println(admin);
        model.addAttribute("admin",admin);
    }

    @RequestMapping("/index")
    public String doLogin(Model model, Principal principal) {

        model.addAttribute("title","Admin Dashboard");

        return "add_menu";

    }

}
