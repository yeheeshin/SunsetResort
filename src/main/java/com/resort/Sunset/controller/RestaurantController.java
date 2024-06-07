package com.resort.Sunset.controller;

import com.resort.Sunset.dto.restaurant;
import com.resort.Sunset.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantService restaurantService;

    @GetMapping("/restaurant")
    public String blog(Model model) {
        List<restaurant> restaurants = restaurantService.selectAll();

        model.addAttribute("restaurants", restaurants);

        return "/restaurant";
    }

}
