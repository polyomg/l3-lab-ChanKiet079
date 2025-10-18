package com.poly.demo.service;

import org.springframework.stereotype.Service;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Arrays;

@Service
public class CookieService {
    private final HttpServletRequest request;
    private final HttpServletResponse response;

    public CookieService(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    public Cookie get(String name) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null) return null;
        return Arrays.stream(cookies)
                .filter(c -> c.getName().equals(name))
                .findFirst().orElse(null);
    }

    public String getValue(String name) {
        Cookie c = get(name);
        return c == null ? "" : c.getValue();
    }

    public Cookie add(String name, String value, int hours) {
        Cookie c = new Cookie(name, value);
        c.setPath("/");
        c.setMaxAge(hours * 3600);
        response.addCookie(c);
        return c;
    }

    public void remove(String name) {
        Cookie c = new Cookie(name, "");
        c.setPath("/");
        c.setMaxAge(0);
        response.addCookie(c);
    }
}
