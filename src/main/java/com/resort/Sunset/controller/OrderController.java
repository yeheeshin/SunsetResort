package com.resort.Sunset.controller;

import com.resort.Sunset.dto.restaurant;
import com.resort.Sunset.dto.room;
import com.resort.Sunset.dto.store;
import com.resort.Sunset.dto.users;
import com.resort.Sunset.form.fileForm;
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

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class OrderController {
    private final RoomService roomService;

    @PostMapping("/roomRes")
    public String room_res(Model model) {
        List<Long> longs = roomService.allRoomIds();
        List<room> allRoom = new ArrayList<>();

        for (Long roomId : longs) {
            room room = roomService.getRoom(roomId);

            allRoom.add(room);
        }

        model.addAttribute("allRoom", allRoom);

        return "/roomRes";
    }


}
