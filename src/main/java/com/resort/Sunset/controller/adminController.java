package com.resort.Sunset.controller;

import com.resort.Sunset.dto.admin_user;
import com.resort.Sunset.dto.ranking;
import com.resort.Sunset.dto.users;
import com.resort.Sunset.form.resForm;
import com.resort.Sunset.service.AdminUserService;
import com.resort.Sunset.service.RankService;
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
public class adminController {
    private final UserService userService;
    private final RankService rankService;
    private final PasswordEncoder passwordEncoder;
    private final AdminUserService adminUserService;


    @GetMapping("/admin")
    public String admin() {
        return "/admin/admin";
    }

    @GetMapping("/adminManage")
    public String adminManage(Model model) {
        admin_user adminUser = new admin_user();
        model.addAttribute("adminUser", adminUser);

        List<admin_user> adminUserList = adminUserService.findAll();
        model.addAttribute("adminUserList", adminUserList);

        return "/admin/adminManage";
    }

    @GetMapping("/resManage")
    public String resManage() {
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
}

