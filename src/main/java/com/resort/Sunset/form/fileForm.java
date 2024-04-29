package com.resort.Sunset.form;

import com.resort.Sunset.utils.MyPath;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Getter
@Setter
public class fileForm {
    private MultipartFile file;

    public static String uploadFileName(fileForm fileForm) throws IOException {
        String filename = fileForm.getFile().getOriginalFilename();
        Path filePath = Paths.get(MyPath.filePath + filename);
        Files.write(filePath, fileForm.getFile().getBytes());

        UUID uuid = UUID.randomUUID();
        String fileName = uuid + "_" + filename;

        System.out.println("fileName = " + fileName);

        return fileName;
    }
}
