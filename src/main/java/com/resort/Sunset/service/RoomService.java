package com.resort.Sunset.service;

import com.resort.Sunset.dto.room;
import com.resort.Sunset.mapper.RoomMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class RoomService {
    private final RoomMapper roomMapper;

    public room getRoom(Long rid) {
        return roomMapper.selectById(rid);
    }

    public room fileUpload(String fileName) {
        return roomMapper.fileUpload(fileName);
    }

    public List<String> roomBed(Long rid) {
        return roomMapper.duplicateBed(rid);
    }

    public List<String> roomView(Long rid) {
        return roomMapper.duplicateView(rid);
    }

}
