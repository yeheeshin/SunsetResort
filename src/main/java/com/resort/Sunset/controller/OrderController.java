package com.resort.Sunset.controller;

import com.resort.Sunset.dto.*;
import com.resort.Sunset.form.fileForm;
import com.resort.Sunset.form.resForm;
import com.resort.Sunset.service.*;
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
    private final RoomReserveService roomReserveService;
    private final UserService userService;

    @PostMapping("/roomRes")
    public String room_res(@ModelAttribute resForm resForm, Model model) {
        if (userService.nowUser() == null) {
            model.addAttribute("errorMessage", "로그인 후, 예약 바랍니다.");

            return "/login";
        }

        List<room> roomIds = new ArrayList<>();
        List<String> roomView = new ArrayList<>();
        List<Integer> roomPrice = new ArrayList<>();

        LocalDate in_date = LocalDate.parse(resForm.getHidden_openDate());
        LocalDate out_date = LocalDate.parse(resForm.getHidden_finDate());

        System.out.println("out_date = " + out_date);
        System.out.println("in_date = " + in_date);

        // 예약 가능한 객실 id
        List<Long> avRoom = roomService.checkRoomRes(in_date, out_date);

        for (int i = 0; i < avRoom.size(); i++) {
            // 예약 가능한 객실 정보 가져오기
            roomIds.add(roomService.getRoom(avRoom.get(i)));

            // 전망 가져오기
            List<String> view = roomService.roomView(avRoom.get(i));
            roomView.add(i, String.join(" / ", view));

            // 가격 가져오기
            room_price price = roomService.getPrice(avRoom.get(i));
            roomPrice.add(i, price.getPrice());
        }

        model.addAttribute("roomIds", roomIds);
        model.addAttribute("roomView", roomView);
        model.addAttribute("roomPrice", roomPrice);

        return "/roomRes";
    }

    // 예약 하기
    @PostMapping("/orderDe")
    public String orderDe(@ModelAttribute room_reserve reserve, Model model) {
        users users = userService.nowUser();
        reserve.setUser_id(users.getUser_id());

        System.out.println(reserve.getTotal_price() + " 이거야 ");

        userService.orderPoint(users, reserve.getTotal_price());
        roomReserveService.saveRoomRes(reserve);
        model.addAttribute("Message", "예약이 완료되었습니다.");



        return "/index";
    }


}
