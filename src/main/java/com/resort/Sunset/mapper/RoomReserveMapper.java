package com.resort.Sunset.mapper;

import com.resort.Sunset.dto.amenities;
import com.resort.Sunset.dto.room_reserve;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoomReserveMapper {
    // id, user 를 이용해서 객실 예약 정보 가져오기
    room_reserve selectByResId(Long re_id, Long user_id);

    // 예약 정보 저장
    void saveRoomRes(room_reserve room_reserve);

    // 회원의 예약들 가져오기
    List<room_reserve> selectByUserId(Long user_id);

    // 예약 번호로 예약 정보 가져오기
    room_reserve selectByReId(Long re_id);
}


