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
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class RoomDetailController {

    private final RoomService roomService;
    private final AmenitiesService amenitiesService;
    private final ImgAllService imgAllService;

    // 객실 상세페이지 로드
    @GetMapping("/roomDetail")
    public String roomDetail(@RequestParam("id") Long room_id, Model model) {
        // id로 객실 정보 가져오기
        room room = roomService.getRoom(room_id);

        // 객실에 있는 어메니티 아이디 가져오기
        Long amId = room.getAm_id();
        amenities amenities = amenitiesService.getAmenities(amId);

        // 객실 이미지 가져오기
        List<img_all> roomImg = imgAllService.getRoomImg(room_id);

        System.out.println("amId = " + amId);

        model.addAttribute("rooms", room);
        model.addAttribute("amenities", amenities);
        model.addAttribute("roomImg", roomImg);

        return "/room-details";
    }

}
