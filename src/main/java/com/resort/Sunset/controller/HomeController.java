package com.resort.Sunset.controller;

import com.resort.Sunset.dto.*;
import com.resort.Sunset.form.fileForm;
import com.resort.Sunset.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final StoreService storeService;
    private final RestaurantService restaurantService;
    private final RoomService roomService;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final RankService rankService;

    @GetMapping("/")
    public String home(Model model) {
        List<store> storeTop = storeService.getTop();
        List<room> roomTop = roomService.getTop();

        model.addAttribute("storeTop", storeTop);
        model.addAttribute("roomTop", roomTop);

        return "index";
    }

    @GetMapping("/about")
    public String about() {
        return "/about-us";
    }

    @GetMapping("/blogDetail")
    public String blogDetail() {
        return "/blog-details";
    }

    @GetMapping("/contact")
    public String contact() {
        return "/contact";
    }

    @GetMapping("/ex")
    public String ex(fileForm fileForm, Model model) {
        // 갖고 있는 부대시설, 레스토랑, 객실 모두 조회
        List<store> stores = storeService.selectAll();
        List<restaurant> restaurants = restaurantService.selectAll();
        List<room> rooms = roomService.selectAll();

        model.addAttribute("store", stores);
        model.addAttribute("restaurant", restaurants);
        model.addAttribute("rooms", rooms);
        model.addAttribute("allFile", fileForm);

        return "/ex";
    }

    @GetMapping("/login")
    public String login() {
        return "/login";
    }

    @GetMapping("/sign")
    public String signUp(Model model) {

        users user = new users();

        model.addAttribute("user", user);
        return "/signup";
    }

    @PostMapping("/sign")
    public String join(Model model, @ModelAttribute("user") users user) {
        String duplicateUser = userService.isDuplicateUser(user);

        if (duplicateUser != "") {
            model.addAttribute("errorMessage", duplicateUser);

            return "/signup";
        }

        user.setPwd(passwordEncoder.encode(user.getPwd()));

        userService.saveUser(user);

        return "/login";
    }

    @GetMapping("/loginError")
    public String errorPage(Model model) {
        model.addAttribute("errorMessage", "아이디 또는 비밀번호를 확인해주세요");

        return "/login";
    }

    @GetMapping("/membership")
    public String membership(Model model) {
        users users = userService.nowUser();

        Long rankId = users.getRank_id();
        ranking rank = rankService.getRanking(rankId);

        model.addAttribute("users", users);
        model.addAttribute("rank", rank);

        return "/memberShip";
    }
}
