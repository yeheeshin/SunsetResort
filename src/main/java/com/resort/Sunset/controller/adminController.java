package com.resort.Sunset.controller;

import com.resort.Sunset.dto.*;
import com.resort.Sunset.dto.enumType.role;
import com.resort.Sunset.form.resForm;
import com.resort.Sunset.service.*;
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
public class adminController {
    private final UserService userService;
    private final RankService rankService;
    private final RoomService roomService;
    private final RoomReserveService roomReserveService;
    private final PasswordEncoder passwordEncoder;
    private final AdminUserService adminUserService;


    @GetMapping("/admin")
    public String admin() {
        return "/admin/admin";
    }

    // 관리자 관리
    @GetMapping("/adminManage")
    public String adminManage(Model model) {
        admin_user adminUser = new admin_user();
        model.addAttribute("adminUser", adminUser);

        List<admin_user> adminUserList = adminUserService.findAll();
        model.addAttribute("adminUserList", adminUserList);

        return "/admin/adminManage";
    }

    // 관리자 관리 수정 페이지 이동
    @GetMapping("/adminManageEdit")
    public String adminManageEdit(@RequestParam("id") Long au_id, Model model) {
        admin_user adminUser = adminUserService.findByauId(au_id);
        model.addAttribute("adminUser", adminUser);

        role[] roles = role.values();
        model.addAttribute("roles", roles);

        return "/admin/adminManageEdit";
    }

    // 관리자 관리 수정
    @PostMapping("/adminManageEdit")
    public String adminEdit(@ModelAttribute admin_user adminUser, Model model) {
        adminUserService.updateAdmin(adminUser);

        return "redirect:/adminManage";
    }

    // 예약 관리 창
    @GetMapping("/resManage")
    public String resManage(Model model) {
        List<room_reserve> reserveList = roomReserveService.getAll();
        model.addAttribute("reserveList", reserveList);

        List<room> roomList = new ArrayList<>();
        List<users> usersList = new ArrayList<>();

        for (room_reserve reserve : reserveList) {
            Long roomId = reserve.getRoom_id();
            room room = roomService.getRoom(roomId);

            Long userId = reserve.getUser_id();
            users user = userService.getUser(userId);

            usersList.add(user);
            roomList.add(room);
        }

        model.addAttribute("roomList", roomList);
        model.addAttribute("usersList", usersList);

        return "/admin/resManage";
    }

    // 회원 관리 페이지
    @GetMapping("/userManage")
    public String userManage(Model model) {
        List<users> allUser = userService.userAll();

        users addUser = new users();

        List<ranking> userRank = new ArrayList<>();

        for (int i = 0; i < allUser.size(); i++) {
            Long rankId = allUser.get(i).getRank_id();

            userRank.add(i, rankService.getRanking(rankId));
        }

        model.addAttribute("allUser", allUser);
        model.addAttribute("userRank", userRank);
        model.addAttribute("addUser", addUser);

        return "/admin/userManage";
    }

    @GetMapping("/adminMessage")
    public String adminMessage() {
        return "/admin/adminMessage";
    }

    @GetMapping("/userEditA")
    public String userEditAdmin(@RequestParam("email") String userEmail, Model model) {
        users user = userService.getUser(userEmail);

        model.addAttribute("user", user);

        return "/admin/userAdminEdit";
    }

    @PostMapping("/userEditA")
    public String userEditA(@ModelAttribute users user, Model model) {

        userService.updateUser(user);

        return "redirect:/userManage";

    }

    @GetMapping("/returnUM")
    public String returnUM() {
        return "redirect:/userManage";
    }

    @PostMapping("/addAdmin")
    public String addAdmin(@ModelAttribute admin_user adminUser, Model model) {
        adminUser.setPwd(passwordEncoder.encode(adminUser.getPwd()));
        adminUserService.saveAdmin(adminUser);

        return "redirect:/userManage";
    }

    // 예약 관리 상세 창
    // 예약 상세 정보 띄우기
    @GetMapping("/resManageInfo")
    public String resManageInfo(@RequestParam("id") Long re_id, Model model) {

        room_reserve res = roomReserveService.getRes(re_id);
        model.addAttribute("res", res);

        Long roomId = res.getRoom_id();
        room room = roomService.getRoom(roomId);
        model.addAttribute("room", room);

        return "admin/resManageDetail";
    }
}

