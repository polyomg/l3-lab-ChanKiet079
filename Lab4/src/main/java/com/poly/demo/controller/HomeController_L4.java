package com.poly.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController_L4 {

    @RequestMapping("/home/index_L4")
    public String index(Model model) {
        return "home_L4";
    }

    @RequestMapping("/home/about_L4")
    public String about(Model model) {
        return "about_L4";
    }
}
