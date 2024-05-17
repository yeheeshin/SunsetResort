package com.resort.Sunset.controller;

import com.resort.Sunset.dto.room;
import com.resort.Sunset.form.fileForm;
import com.resort.Sunset.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final RoomService roomService;


    @GetMapping("/about")
    public String about() {
        return "/about-us";
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

    @GetMapping("/ex")
    public String ex(fileForm fileForm, Model model) {
        model.addAttribute("allFile", fileForm);

        return "/ex";
    }

    @GetMapping("/roomRes")
    public String roomRes() {
        return "/roomRes";
    }

    @GetMapping("/rOrder")
    public String roomOrder() {
        return "/roomOrder";
    }

    @GetMapping("/orderDe")
    public String orderDe() {
        return "/orderDetail";
    }


}
