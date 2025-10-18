package com.poly.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ctrl")
public class OkController {

    // Mapping 1
    @RequestMapping("/ok")
    public String ok() {
        return "ok";  // -> ok.html
    }

    // Mapping 2
    @RequestMapping("/ok2")
    public String ok1() {
        return "ok2"; // -> ok2.html
    }

    // Mapping 3
    @RequestMapping("/ok3")
    public String ok2() {
        return "ok3"; // -> ok3.html
    }
}
