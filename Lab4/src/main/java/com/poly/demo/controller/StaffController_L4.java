package com.poly.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import jakarta.validation.Valid;
import com.poly.demo.entity.Staff_L4;

@Controller
public class StaffController_L4 {

    @RequestMapping("/staff/create/form_L4")
    public String createForm(Model model) {
        model.addAttribute("staff", new Staff_L4());
        model.addAttribute("message", "Vui lòng nhập thông tin nhân viên!");
        return "staff-validate_L4";
    }

    @RequestMapping("/staff/create/save_L4")
    public String createSave(Model model,
                             @RequestPart("photo_file") MultipartFile photoFile,
                             @Valid @ModelAttribute("staff") Staff_L4 staff,
                             Errors errors) {

        if (!photoFile.isEmpty()) {
            staff.setPhoto(photoFile.getOriginalFilename());
        }

        if (errors.hasErrors()) {
            model.addAttribute("message", "Vui lòng sửa các lỗi sau!");
        } else {
            model.addAttribute("message", "Dữ liệu đã nhập đúng!");
        }

        return "staff-validate_L4";
    }
}
