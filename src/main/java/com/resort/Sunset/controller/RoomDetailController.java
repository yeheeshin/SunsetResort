package com.resort.Sunset.controller;

import com.resort.Sunset.dto.room;
import com.resort.Sunset.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class RoomDetailController {

    private final RoomService roomService;

    @GetMapping("/roomDetail")
    public String roomDetail(Model model) {
        Long rid = 1L;
        room room = roomService.getRoom(rid);

        model.addAttribute("rooms", room);

        return "/room-details";
    }
}
