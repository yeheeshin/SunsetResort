package com.resort.Sunset.controller;

import com.resort.Sunset.dto.room;
import com.resort.Sunset.dto.room_reserve;
import com.resort.Sunset.dto.users;
import com.resort.Sunset.service.RoomReserveService;
import com.resort.Sunset.service.RoomService;
import com.resort.Sunset.service.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MyPageController {

    private final RoomReserveService roomReserveService;
    private final UserService userService;
    private final RoomService roomService;

    private final PasswordEncoder passwordEncoder;

    // 마이페이지 띄우기
    @GetMapping("/myPage")
    public String myPage(Model model) {
        List<room> roomInfo = new ArrayList<>();

        // 지금 로그인 한 id 사용해서 예약 목록 가져오기
        List<room_reserve> resById = roomReserveService.getResById(userService.nowUser().getUser_id());

        // 예약한 방에 대한 정보 가져오기
        for (room_reserve res : resById) {
            Long roomId = res.getRoom_id();

            room room = roomService.getRoom(roomId);
            roomInfo.add(room);
        }

        model.addAttribute("resList", resById);
        model.addAttribute("roomInfo", roomInfo);

        return "/myPage";
    }

    // 내 정보 수정 창 띄우기
    @GetMapping("/info")
    public String myInfo(Model model) {
        users users = userService.nowUser();
        model.addAttribute("user", users);

        return "/myInfo";
    }

    // 비밀번호가 일치 할 경우, 내 정보 수정
    @PostMapping("/userEdit")
    public String editUser(@ModelAttribute users user, @RequestParam("pwd") String pwd) {
        users nowUser = userService.nowUser();

        if (passwordEncoder.matches(pwd,nowUser.getPwd())) {
            nowUser.setName(user.getName());
            nowUser.setPhone(user.getPhone());

            userService.updateUser(nowUser);
        }
        return "redirect:/myPage";
    }

    // 예약 상세 정보 띄우기
    @GetMapping("/resInfo")
    public String resInfo(@RequestParam("id") Long re_id, Model model) {

        room_reserve res = roomReserveService.getRes(re_id);
        model.addAttribute("res", res);

        Long roomId = res.getRoom_id();
        room room = roomService.getRoom(roomId);
        model.addAttribute("room", room);

        return "booking_detail";
    }

}
