package com.resort.Sunset.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class adminController {

    @GetMapping("/admin")
    public String admin() {
        return "/admin/admin";
    }

    @GetMapping("/adminManage")
    public String adminManage() {
        return "/admin/adminManage";
    }

    @GetMapping("/resManage")
    public String resManage() {
        return "/admin/resManage";
    }

    @GetMapping("/userManage")
    public String userManage() {
        return "/admin/userManage";
    }

    @GetMapping("/adminMessage")
    public String adminMessage() {
        return "/admin/adminMessage";
    }
}

