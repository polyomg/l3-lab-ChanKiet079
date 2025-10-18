package com.poly.demo.controller;

import com.poly.demo.entity.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class ProductController {

    // Bài 3: form nhập sản phẩm
    @GetMapping("/product/form")
    public String form() {
        return "product_form"; // đổi thành file product_form.html
    }

    @PostMapping("/product/save")
    public String save(Model model, @ModelAttribute Product p) {
        model.addAttribute("p", p);
        return "product_form";
    }

    // Bài 4: mở rộng
    @GetMapping("/product/form2")
    public String form2(Model model) {
        Product p = new Product();
        p.setName("iPhone 30");
        p.setPrice(5000.0);
        model.addAttribute("p1", p);
        return "product_form";
    }

    @PostMapping("/product/save2")
    public String save2(Model model, @ModelAttribute("p2") Product p) {
        model.addAttribute("p2", p);
        return "product_form";
    }

    @ModelAttribute("items")
    public List<Product> getItems() {
        return Arrays.asList(new Product("A", 1.0), new Product("B", 12.0));
    }
}
