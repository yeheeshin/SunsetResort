package com.resort.Sunset.service;

import com.resort.Sunset.dto.amenities;
import com.resort.Sunset.dto.room_reserve;
import com.resort.Sunset.mapper.AmMapper;
import com.resort.Sunset.mapper.RoomReserveMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class RoomReserveService {
    private final RoomReserveMapper reserveMapper;

    public room_reserve getRoomRes(Long re_id, Long user_id) {
        return reserveMapper.selectByResId(re_id, user_id);
    }

    public room_reserve getRes(Long re_id) {
        return reserveMapper.selectByReId(re_id);
    }

    // 예약 저장
    public void saveRoomRes(room_reserve room_reserve) {
        reserveMapper.saveRoomRes(room_reserve);
    }

    // 회원 id로 예약 목록 가져오기
    public List<room_reserve> getResById(Long user_id) {
        return reserveMapper.selectByUserId(user_id);
    }
}
