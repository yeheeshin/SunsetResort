package com.resort.Sunset.controller;

import com.resort.Sunset.dto.room_reserve;
import com.resort.Sunset.service.RoomReserveService;
import com.resort.Sunset.service.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MyPageController {

    private final RoomReserveService roomReserveService;
    private final UserService userService;

    @GetMapping("/myPage")
    public String myPage(Model model) {
        List<room_reserve> resById = roomReserveService.getResById(userService.nowUser().getUser_id());

        model.addAttribute("resList", resById);

        return "/myPage";
    }

}
