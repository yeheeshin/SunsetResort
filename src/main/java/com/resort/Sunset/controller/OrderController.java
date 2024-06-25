package com.resort.Sunset.controller;

import com.resort.Sunset.dto.*;
import com.resort.Sunset.form.fileForm;
import com.resort.Sunset.form.resForm;
import com.resort.Sunset.service.RestaurantService;
import com.resort.Sunset.service.RoomService;
import com.resort.Sunset.service.StoreService;
import com.resort.Sunset.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class OrderController {
    private final RoomService roomService;

    @PostMapping("/roomRes")
    public String room_res(@ModelAttribute resForm resForm,
                           Model model) {
        List<Long> roomAvailable = roomService.isRoomAvailable();

        List<room> allRoom = new ArrayList<>();
        List<String> roomView = new ArrayList<>();
        List<Integer> roomPrice = new ArrayList<>();


        for (int i = 0; i < roomAvailable.size(); i++) {
            // 객실 전망 가져오기
            List<String> view = roomService.roomView(roomAvailable.get(i));
            roomView.add(i, String.join(" / ", view));

            // 객실 정보 가져오기
            room room = roomService.getRoom(roomAvailable.get(i));
            allRoom.add(room);

            // 객실 가격 가져오기
            room_price price = roomService.getPrice(roomAvailable.get(i));
            roomPrice.add(i, price.getPrice());
        }


        model.addAttribute("allRoom", allRoom);
        model.addAttribute("roomView", roomView);
        model.addAttribute("roomPrice", roomPrice);

        System.out.println("체크인 날짜 : " + resForm.getHidden_openDate());


        return "/roomRes";
    }


}
