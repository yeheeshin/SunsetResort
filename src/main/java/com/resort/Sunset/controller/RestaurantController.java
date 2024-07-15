package com.resort.Sunset.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.resort.Sunset.dto.img_all;
import com.resort.Sunset.dto.menuFile;
import com.resort.Sunset.dto.restaurant;
import com.resort.Sunset.mapper.MenuFileMapper;
import com.resort.Sunset.service.ImgAllService;
import com.resort.Sunset.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantService restaurantService;
    private final ImgAllService imgAllService;
    private final MenuFileMapper menuFileMapper;

    // 레스토랑 목록 가져오기
    @GetMapping("/restaurant")
    public String blog(Model model) {
        List<restaurant> restaurants = restaurantService.selectAll();

        model.addAttribute("restaurants", restaurants);

        return "/restaurant";
    }

    // 레스토랑 상세 페이지 띄우기
    @GetMapping("/res_detail")
    public String res_detail(@RequestParam("id") Long res_id, Model model) {
        restaurant restaurant = restaurantService.selectResId(res_id);

        List<menuFile> menuFiles = menuFileMapper.selectByResId(res_id);

        List<img_all> resImg = imgAllService.getResImg(res_id);

        // roomImg를 JSON 형식으로 변환
        ObjectMapper objectMapper = new ObjectMapper();
        String resImgJson = "";
        try {
            resImgJson = objectMapper.writeValueAsString(resImg);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        List<String> res_menu = Arrays.asList(restaurant.getMenu().split(";"));

        System.out.println("res_menu.get(0) = " + res_menu.get(0));

        model.addAttribute("restaurant", restaurant);
        model.addAttribute("resImgJson", resImgJson);
        model.addAttribute("menuFiles", menuFiles);
        model.addAttribute("res_menu", res_menu);

        return "/res_detail";
    }
}
