package com.resort.Sunset.controller;

import com.resort.Sunset.dto.promotion;
import com.resort.Sunset.dto.restaurant;
import com.resort.Sunset.dto.room;
import com.resort.Sunset.dto.store;
import com.resort.Sunset.form.fileForm;
import com.resort.Sunset.service.PromotionService;
import com.resort.Sunset.service.RestaurantService;
import com.resort.Sunset.service.RoomService;
import com.resort.Sunset.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final PromotionService promotionService;
    private final StoreService storeService;
    private final RestaurantService restaurantService;
    private final RoomService roomService;

    @GetMapping("/about")
    public String about() {
        return "/about-us";
    }

    @GetMapping("/blog")
    public String blog() {
        return "/blog";
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
        // 갖고 있는 프로모션, 부대시설, 레스토랑, 객실 모두 조회
        List<promotion> promotions = promotionService.selectAll();
        List<store> stores = storeService.selectAll();
        List<restaurant> restaurants = restaurantService.selectAll();
        List<room> rooms = roomService.selectAll();

        model.addAttribute("promotion", promotions);
        model.addAttribute("store", stores);
        model.addAttribute("restaurant", restaurants);
        model.addAttribute("rooms", rooms);
        model.addAttribute("allFile", fileForm);

        return "/ex";
    }

    @GetMapping("/roomRes")
    public String roomRes() {
        return "/roomRes";
    }

    @GetMapping("/rOrder")
    public String roomOrder() {
        return "/roomOrder";
    }

    @GetMapping("/orderDe")
    public String orderDe() {
        return "/orderDetail";
    }


}
