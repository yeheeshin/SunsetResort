package com.resort.Sunset.controller;

import com.resort.Sunset.dto.amenities;
import com.resort.Sunset.dto.room;
import com.resort.Sunset.service.AmenitiesService;
import com.resort.Sunset.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;

    @GetMapping("/room")
    public String roomDetail(Model model) {
        Long rid = 1L;

        List<String> roomBed = roomService.roomBed(rid);
        List<String> roomView = roomService.roomView(rid);

        String roomBedString = String.join(" / ", roomBed);
        String roomViewString = String.join(" / ", roomView);

        model.addAttribute("roomBedString", roomBedString);
        model.addAttribute("roomViewString", roomViewString);

        return "/rooms";
    }
}
