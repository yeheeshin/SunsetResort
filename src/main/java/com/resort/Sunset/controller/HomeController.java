package com.resort.Sunset.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {

    @GetMapping("/room")
    public String room() {
        return "/rooms";
    }

    @GetMapping("/about")
    public String about() {
        return "/about-us";
    }

    @GetMapping("/roomDetail")
    public String roomDetail() {
        return "/room-details";
    }

    @GetMapping("/blog")
    public String blog() {
        return "/blog";
    }

    @GetMapping("/blogDetail")
    public String blogDetail() {
        return "/blog-details";
    }

    @GetMapping("/contact")
    public String contact() {
        return "/contact";
    }

}
