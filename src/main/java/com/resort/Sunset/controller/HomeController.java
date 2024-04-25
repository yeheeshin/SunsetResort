package com.resort.Sunset.controller;

import com.resort.Sunset.dto.room;
import com.resort.Sunset.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final RoomService roomService;


    @GetMapping("/room")
    public String room() {
        return "/rooms";
    }

    @GetMapping("/about")
    public String about() {
        return "/about-us";
    }

    @GetMapping("/roomDetail")
    public String roomDetail(Model model) {
        Long rid = 1L;
        room room = roomService.getRoom(rid);

//        System.out.println("room.getName() = " + room.getName());

        
        model.addAttribute("rooms", room);

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

    @GetMapping("/ex")
    public String ex() {
        return "/ex";
    }
}
