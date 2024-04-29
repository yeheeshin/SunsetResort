package com.resort.Sunset.controller;

import com.resort.Sunset.dto.room;
import com.resort.Sunset.form.fileForm;
import com.resort.Sunset.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class FileController {
    private final RoomService roomService;


    @PostMapping("fileUp")
    public String fileUpload(@ModelAttribute("allFile") fileForm fileForm) {

        try {
            String fileName = fileForm.uploadFileName(fileForm);
            room roomFile = roomService.fileUpload(fileName);

            return "rooms";
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
