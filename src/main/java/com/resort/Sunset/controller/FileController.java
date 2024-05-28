package com.resort.Sunset.controller;

import com.resort.Sunset.dto.img_all;
import com.resort.Sunset.dto.room;
import com.resort.Sunset.form.fileForm;
import com.resort.Sunset.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class FileController {
    private final RoomService roomService;


    @PostMapping("fileUp")
    public String fileUpload(fileForm fileData) {

        try {
            List<MultipartFile> files = fileData.getFile();// -> list
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
