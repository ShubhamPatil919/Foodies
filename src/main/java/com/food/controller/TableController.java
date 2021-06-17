package com.food.controller;


import com.food.entity.Seating;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/table")
public class TableController {

    @GetMapping("/add-process")
    public String addProces(Model model)
    {
        model.addAttribute("table",new Seating());
        return "add-table";
    }
}
