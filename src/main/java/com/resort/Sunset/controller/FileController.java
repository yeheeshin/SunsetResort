package com.resort.Sunset.controller;

import com.resort.Sunset.dto.restaurant;
import com.resort.Sunset.dto.room;
import com.resort.Sunset.dto.store;
import com.resort.Sunset.form.fileForm;
import com.resort.Sunset.service.RestaurantService;
import com.resort.Sunset.service.RoomService;
import com.resort.Sunset.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class FileController {
    private final RoomService roomService;
    private final StoreService storeService;
    private final RestaurantService restaurantService;

    // 호텔 정보 업로드 할 수 있는 창 띄우기
    @GetMapping("/dataUpload")
    public String dataUp(fileForm fileForm, Model model) {
        // 갖고 있는 부대시설, 레스토랑, 객실 모두 조회
        List<store> stores = storeService.selectAll();
        List<restaurant> restaurants = restaurantService.selectAll();
        List<room> rooms = roomService.selectAll();

        model.addAttribute("store", stores);
        model.addAttribute("restaurant", restaurants);
        model.addAttribute("rooms", rooms);
        model.addAttribute("allFile", fileForm);

        return "dataUpload";
    }

    // 호텔 데이터 저장
    @PostMapping("fileUp")
    public String fileUpload(fileForm fileData) {

        try {
            List<MultipartFile> files = fileData.getFile();
            for (MultipartFile file : files) {
                Map<String, Object> fileAllData = fileForm.uploadFileName(file,fileData);
                roomService.insertImg(fileAllData);
            }

            return "redirect:/room";
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
