package com.resort.Sunset.service;

import com.resort.Sunset.dto.amenities;
import com.resort.Sunset.dto.room_reserve;
import com.resort.Sunset.mapper.AmMapper;
import com.resort.Sunset.mapper.RoomReserveMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class RoomReserveService {
    private final RoomReserveMapper reserveMapper;

    public room_reserve getRoomRes(Long re_id, Long user_id) {
        return reserveMapper.selectByResId(re_id, user_id);
    }

    // 예약 저장
    public void saveRoomRes(room_reserve room_reserve) {
        reserveMapper.saveRoomRes(room_reserve);
    }
}
