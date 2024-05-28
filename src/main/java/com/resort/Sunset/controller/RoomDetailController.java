package com.resort.Sunset.controller;

import com.resort.Sunset.dto.amenities;
import com.resort.Sunset.dto.room;
import com.resort.Sunset.service.AmenitiesService;
import com.resort.Sunset.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class RoomDetailController {

    private final RoomService roomService;
    private final AmenitiesService amenitiesService;


    @GetMapping("/roomDetail")
    public String roomDetail(@RequestParam("id") Long room_id, Model model) {
        room room = roomService.getRoom(room_id);

        Long amId = room.getAm_id();
        amenities amenities = amenitiesService.getAmenities(amId);

        System.out.println("amId = " + amId);

        model.addAttribute("rooms", room);
        model.addAttribute("amenities", amenities);

        return "/room-details";
    }
}
