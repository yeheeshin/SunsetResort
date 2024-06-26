package com.resort.Sunset.service;

import com.resort.Sunset.dto.img_all;
import com.resort.Sunset.dto.room;
import com.resort.Sunset.dto.room_price;
import com.resort.Sunset.dto.room_reserve;
import com.resort.Sunset.mapper.RoomMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
@RequiredArgsConstructor
public class RoomService {
    private final RoomMapper roomMapper;

    public List<room> selectAll() {
        return roomMapper.allRoom();
    }

    public room getRoom(Long room_id) {
        return roomMapper.selectById(room_id);
    }

    // 4개의 객실 정보 가져오기
    public List<room> getTop() {
        return roomMapper.selectTop();
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

    // 모든 객실 pk 가져오기
    public List<Long> allRoomIds() {
        List<room> rooms = roomMapper.allRoom();

        List<Long> roomIds = new ArrayList<>();

        for (int i = 0; i < rooms.size(); i++) {
            roomIds.add(i, rooms.get(i).getRoom_id());
        }

        return roomIds;
    }

    // 성수기, 비수기에 따른 객실 가격 가져오기
    public room_price getPrice(Long room_id) {
        String diff = "";
        LocalDate nowDate = LocalDate.now();
        int monthValue = nowDate.getMonthValue();

        if (monthValue == 6 || monthValue == 7 || monthValue == 8) {
            diff = "peak";
        } else {
            diff = "off";
        }

        return roomMapper.getPrice(room_id, diff);

    }

    // 날짜에 따른 객실 예약 가능 여부 확인
    public List<Long> checkRoomRes(LocalDate in_date, LocalDate out_date) {
        List<Long> roomReserve = roomMapper.checkRoomRes(in_date, out_date);

        return roomReserve;
    }
}
