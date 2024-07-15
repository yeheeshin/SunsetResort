package com.resort.Sunset.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.resort.Sunset.dto.img_all;
import com.resort.Sunset.dto.store;
import com.resort.Sunset.service.ImgAllService;
import com.resort.Sunset.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
@RequiredArgsConstructor
public class StoreController {

    private final StoreService storeService;
    private final ImgAllService imgAllService;

    // 부대시설 리스트 출력
    @GetMapping("/store")
    public String about(Model model) {
        List<store> stores = storeService.selectAll();

        model.addAttribute("stores", stores);

        return "list/storeList";
    }

    // 부대시설 상세 페이지 로드
    @GetMapping("/storeDetail")
    public String storeDetail(@RequestParam("id") Long store_id, Model model) {
        store store = storeService.getStore(store_id);

        List<img_all> storeImg = imgAllService.getStoreImg(store_id);

        // storeImg를 JSON 형식으로 변환
        ObjectMapper objectMapper = new ObjectMapper();
        String storeImgJson = "";
        try {
            storeImgJson = objectMapper.writeValueAsString(storeImg);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        model.addAttribute("storeImgJson", storeImgJson);
        model.addAttribute("store", store);

        return "detail/store_details";
    }


}
