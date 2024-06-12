package com.resort.Sunset.form;

import com.resort.Sunset.utils.MyPath;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Getter
@Setter
public class fileForm {
    private List<MultipartFile> file;
    private Long pro_id;
    private Long res_id;
    private Long room_id;
    private Long store_id;

    public static Map<String, Object> uploadFileName(MultipartFile listFile,fileForm fileForm) throws IOException {
        String filename = listFile.getOriginalFilename();
        Path filePath = Paths.get(MyPath.filePath + filename);
        Files.write(filePath, listFile.getBytes());

        UUID uuid = UUID.randomUUID();
        String fileName = uuid + "_" + filename;

        Map<String, Object> params = new HashMap<>();
        params.put("img_name", fileName);
        params.put("res_id", fileForm.getRes_id());
        params.put("room_id", fileForm.getRoom_id());
        params.put("store_id", fileForm.getStore_id());

        return params;
    }
}
