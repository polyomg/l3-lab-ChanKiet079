package com.poly.demo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/hcn")
@Controller
public class HcnController {

    @Autowired
    HttpServletRequest request;

    @GetMapping
    public String form() {
        return "rectangle";
    }

    @PostMapping
    public String calc(Model model) {
        try {
            double d = Double.parseDouble(request.getParameter("length"));
            double r = Double.parseDouble(request.getParameter("width"));

            double dientich = d * r;
            double chuvi = 2 * (d + r);

            String result = "Diện tích: " + dientich + " | Chu vi: " + chuvi;
            model.addAttribute("result", result);

        } catch (Exception e) {
            model.addAttribute("result", "Vui lòng nhập số hợp lệ!");
        }
        return "rectangle";
    }
}
