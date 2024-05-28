package com.resort.Sunset.service;

import com.resort.Sunset.dto.img_all;
import com.resort.Sunset.dto.room;
import com.resort.Sunset.mapper.RoomMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Transactional
@RequiredArgsConstructor
public class RoomService {
    private final RoomMapper roomMapper;

    public room getRoom(Long room_id) {
        return roomMapper.selectById(room_id);
    }

    public void insertImg(Map<String, Object> params) {
        roomMapper.insertImg(params);
    }

    public List<String> roomBed(Long room_id) {
        return roomMapper.duplicateBed(room_id);
    }

    public List<String> roomView(Long room_id) {
        return roomMapper.duplicateView(room_id);
    }

    public List<Long> allRoomIds() {
        List<room> rooms = roomMapper.allRoom();

        List<Long> roomIds = new ArrayList<>();

        for (int i = 0; i < rooms.size(); i++) {
            roomIds.add(i, rooms.get(i).getRoom_id());
        }

        return roomIds;
    }
}
