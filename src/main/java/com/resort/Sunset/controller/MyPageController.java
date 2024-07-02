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

    @GetMapping("/myPage")
    public String myPage(Model model) {
        List<room> roomInfo = new ArrayList<>();

        List<room_reserve> resById = roomReserveService.getResById(userService.nowUser().getUser_id());

        for (room_reserve res : resById) {
            Long roomId = res.getRoom_id();

            room room = roomService.getRoom(roomId);
            roomInfo.add(room);
        }

        model.addAttribute("resList", resById);
        model.addAttribute("roomInfo", roomInfo);

        return "/myPage";
    }

    @GetMapping("/info")
    public String myInfo(Model model) {
        users users = userService.nowUser();
        model.addAttribute("user", users);

        return "/myInfo";
    }

    @PostMapping("/userEdit")
    public String editUser(Model model, @ModelAttribute users user, @RequestParam("pwd") String pwd) {
        users nowUser = userService.nowUser();

        if (passwordEncoder.matches(pwd,nowUser.getPwd())) {
            nowUser.setName(user.getName());
            nowUser.setPhone(user.getPhone());

            userService.updateUser(nowUser);

            System.out.println("여기 지났다네");
        }

        System.out.println(pwd + "??????");

        return "redirect:/myPage";
    }


}
