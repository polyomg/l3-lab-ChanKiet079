package com.poly.demo.controller;

import com.poly.demo.service.CookieService;
import com.poly.demo.service.ParamService;
import com.poly.demo.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AccountController {

    @Autowired
    CookieService cookieService;
    @Autowired
    ParamService paramService;
    @Autowired
    SessionService sessionService;

    @GetMapping("/account/login")
    public String login1() {
        // tên file: login.html
        return "login";
    }

    @PostMapping("/account/login")
    public String login2() {
        String un = paramService.getString("username", "");
        String pw = paramService.getString("password", "");
        boolean rm = paramService.getBoolean("remember", false);

        if ("poly".equals(un) && "123".equals(pw)) {
            sessionService.set("username", un);
            if (rm) {
                cookieService.add("user", un, 24*10); // 10 days
            } else {
                cookieService.remove("user");
            }
            return "redirect:/item/index";
        } else {
            // login thất bại -> vẫn hiện trang login
            return "login";
        }
    }
}
