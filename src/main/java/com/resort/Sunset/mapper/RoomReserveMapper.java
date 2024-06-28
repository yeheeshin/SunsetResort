package com.resort.Sunset.mapper;

import com.resort.Sunset.dto.amenities;
import com.resort.Sunset.dto.room_reserve;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoomReserveMapper {
    // id, user 를 이용해서 객실 예약 정보 가져오기
    room_reserve selectByResId(Long re_id, Long user_id);

    // 예약 정보 저장
    void saveRoomRes(room_reserve room_reserve);
}


