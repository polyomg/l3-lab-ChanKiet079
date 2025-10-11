package com.poly.demo.controller;

import com.poly.demo.entity.Staff;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class StaffController {

    // Bài 1: hiển thị chi tiết 1 Staff
    @RequestMapping("/staff/detail")
    public String detail(Model model) {
        Staff staff = Staff.builder()
                .id("user@gmail.com")
                .fullname("Lê Hoàng Chấn Kiệt")
                .level(2)
                .build();
        model.addAttribute("staff", staff);
        return "/staff-detail";
    }

    // Bài 2: hiển thị danh sách Staff
    @RequestMapping("/staff/list")
    public String list(Model model) {
        List<Staff> list = List.of(
                Staff.builder().id("cklehoang@gmail.com").fullname("lê hoàng chấn kiệt").level(0).build(),
                Staff.builder().id("hung@gmail.com").fullname("nguyễn hoang gia hưng").level(1).build(),
                Staff.builder().id("dung@gmail.com").fullname("nguyễn tấn dũng").level(2).build(),
                Staff.builder().id("user4@gmail.com").fullname("nguyễn văn user4").level(2).build(),
                Staff.builder().id("user5@gmail.com").fullname("nguyễn văn user5").level(1).build(),
                Staff.builder().id("user6@gmail.com").fullname("nguyễn văn user6").level(0).build()
        );
        model.addAttribute("list", list);
        return "/staff-list";
    }

    // Bài 4: hiển thị trạng thái List
    @RequestMapping("/staff/status")
    public String listStatus(Model model) {
        List<Staff> list = List.of(
                Staff.builder().id("cklehoang@gmail.com").fullname("lê hoàng chấn kiệt").level(0).build(),
                Staff.builder().id("hung@gmail.com").fullname("nguyễn hoang gia hưng").level(1).build(),
                Staff.builder().id("dung@gmail.com").fullname("nguyễn tấn dũng").level(2).build(),
                Staff.builder().id("user4@gmail.com").fullname("nguyễn văn user4").level(2).build(),
                Staff.builder().id("user5@gmail.com").fullname("nguyễn văn user5").level(1).build(),
                Staff.builder().id("user6@gmail.com").fullname("nguyễn văn user6").level(0).build()
        );
        model.addAttribute("list", list);
        return "/list-status";
    }

    // Bài 5: đổ dữ liệu vào SelectBox + RadioGroup
    @RequestMapping("/staff/controls")
    public String listControls(Model model) {
        List<Staff> list = List.of(
                Staff.builder().id("cklehoang@gmail.com").fullname("lê hoàng chấn kiệt").level(0).build(),
                Staff.builder().id("hung@gmail.com").fullname("nguyễn hoang gia hưng").level(1).build(),
                Staff.builder().id("dung@gmail.com").fullname("nguyễn tấn dũng").level(2).build(),
                Staff.builder().id("user4@gmail.com").fullname("nguyễn văn user4").level(2).build(),
                Staff.builder().id("user5@gmail.com").fullname("nguyễn văn user5").level(1).build(),
                Staff.builder().id("user6@gmail.com").fullname("nguyễn văn user6").level(0).build()
        );
        model.addAttribute("list", list);
        return "/list-controls";
    }
}
