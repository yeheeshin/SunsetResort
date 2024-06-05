package com.resort.Sunset.controller;

import com.resort.Sunset.dto.amenities;
import com.resort.Sunset.dto.img_all;
import com.resort.Sunset.dto.room;
import com.resort.Sunset.service.AmenitiesService;
import com.resort.Sunset.service.ImgAllService;
import com.resort.Sunset.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;
    private final ImgAllService imgAllService;

    @GetMapping("/room")
    public String roomDetail(Model model) {

        List<Long> roomIds = roomService.allRoomIds();
        List<String> roomBed = new ArrayList<>(), roomView = new ArrayList<>();
        List<room> roomInfo = new ArrayList<>();

        List<img_all> allImg = imgAllService.getAllImg();

        for (int i = 0; i < roomIds.size(); i++) {
            Long roomId = roomIds.get(i);

            List<String> arrBed = roomService.roomBed(roomId);
            List<String> arrView = roomService.roomView(roomId);

            roomBed.add(i, String.join(" / ", arrBed));
            roomView.add(i, String.join(" / ", arrView));

            roomInfo.add(i, roomService.getRoom(roomId));
        }

        model.addAttribute("roomBed", roomBed);
        model.addAttribute("roomView", roomView);
        model.addAttribute("roomInfo", roomInfo);
        model.addAttribute("allImg", allImg);


        return "/rooms";
    }
}
