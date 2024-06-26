package com.resort.Sunset.mapper;

import com.resort.Sunset.dto.img_all;
import com.resort.Sunset.dto.room;
import com.resort.Sunset.dto.room_price;
import com.resort.Sunset.dto.room_reserve;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Mapper
public interface RoomMapper {
    List<room> allRoom();

    room selectById(Long room_id);

    void insertImg(Map<String, Object> params);

    // 객실이 가지고 있는 침대타입 이름들
    List<String> duplicateBed(Long room_id);

    // 객실이 가지고 있는 전망 이름들
    List<String> duplicateView(Long room_id);

    // 객실이 가지고 있는 객실 이미지들
    List<String> oneRoomImg(Long room_id);

    // 4개의 객실 정보 가져오기
    List<room> selectTop();

    // 객실 가격 가져오기
    room_price getPrice(Long room_id, String diff);

    // 날짜에 따른 객실 예약 가능 여부 확인
    List<Long> checkRoomRes(LocalDate in_date, LocalDate out_date);


}
