package com.poly.demo.service;

import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;

@Service
public class SessionService {
    private final HttpSession session;

    public SessionService(HttpSession session) {
        this.session = session;
    }

    @SuppressWarnings("unchecked")
    public <T> T get(String name) {
        Object v = session.getAttribute(name);
        return v == null ? null : (T) v;
    }

    public void set(String name, Object value) {
        session.setAttribute(name, value);
    }

    public void remove(String name) {
        session.removeAttribute(name);
    }
}
