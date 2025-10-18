package com.poly.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ParamService {
    private final HttpServletRequest request;

    public ParamService(HttpServletRequest request) {
        this.request = request;
    }

    public String getString(String name, String defaultValue) {
        String v = request.getParameter(name);
        return (v == null || v.isEmpty()) ? defaultValue : v;
    }

    public int getInt(String name, int defaultValue) {
        String v = request.getParameter(name);
        try {
            return (v == null || v.isEmpty()) ? defaultValue : Integer.parseInt(v);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    public double getDouble(String name, double defaultValue) {
        String v = request.getParameter(name);
        try {
            return (v == null || v.isEmpty()) ? defaultValue : Double.parseDouble(v);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    public boolean getBoolean(String name, boolean defaultValue) {
        String v = request.getParameter(name);
        if (v == null) return defaultValue;
        return v.equalsIgnoreCase("true") || v.equals("1") || v.equalsIgnoreCase("on");
    }

    public Date getDate(String name, String pattern) {
        String v = request.getParameter(name);
        if (v == null || v.isEmpty()) return null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            return sdf.parse(v);
        } catch (ParseException e) {
            throw new RuntimeException("Sai định dạng ngày: " + v);
        }
    }

    // Lưu file vào folder tính từ webroot (ví dụ "/uploads")
    public File save(MultipartFile file, String path) {
        if (file == null || file.isEmpty()) return null;
        String realPath = request.getServletContext().getRealPath(path);
        if (realPath == null) {
            // fallback: lưu vào ./uploads trong working dir
            realPath = System.getProperty("user.dir") + File.separator + "uploads";
        }
        File dir = new File(realPath);
        if (!dir.exists()) dir.mkdirs();
        String original = file.getOriginalFilename();
        File saved = new File(dir, System.currentTimeMillis() + "_" + (original == null ? "file" : original));
        try {
            file.transferTo(saved);
            return saved;
        } catch (IOException e) {
            throw new RuntimeException("Lỗi lưu file: " + e.getMessage());
        }
    }
}
