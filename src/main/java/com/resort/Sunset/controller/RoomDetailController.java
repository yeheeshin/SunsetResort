package com.resort.Sunset.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.resort.Sunset.dto.amenities;
import com.resort.Sunset.dto.img_all;
import com.resort.Sunset.dto.room;
import com.resort.Sunset.dto.room_price;
import com.resort.Sunset.form.resForm;
import com.resort.Sunset.service.AmenitiesService;
import com.resort.Sunset.service.ImgAllService;
import com.resort.Sunset.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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

        // roomImg를 JSON 형식으로 변환
        ObjectMapper objectMapper = new ObjectMapper();
        String roomImgJson = "";
        try {
            roomImgJson = objectMapper.writeValueAsString(roomImg);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        model.addAttribute("rooms", room);
        model.addAttribute("amenities", amenities);
        model.addAttribute("roomImg", roomImg);
        model.addAttribute("roomImgJson", roomImgJson);
        return "room_details";
    }

    // 객실 에약
    @PostMapping("/rEx")
    public String roomRes(@ModelAttribute resForm resForm, Model model, @RequestParam("id") Long roomId) {

        model.addAttribute("resForm", resForm);
        System.out.println("resForm.getAdultCount() = " + resForm.getHidden_adultCount());

        room selRoom = roomService.getRoom(roomId);
        System.out.println("selRoom.getRoom_id() = " + selRoom.getRoom_id());

        room_price selPrice = roomService.getPrice(roomId);

        List<String> roomView = roomService.roomView(roomId);
        String oneView = String.join(" / ", roomView);

        Long amId = selRoom.getAm_id();
        amenities amenities = amenitiesService.getAmenities(amId);

        model.addAttribute("selRoom", selRoom);
        model.addAttribute("selPrice", selPrice);
        model.addAttribute("oneView", oneView);
        model.addAttribute("amenities", amenities);

        return "/roomOrder";
    }

}
