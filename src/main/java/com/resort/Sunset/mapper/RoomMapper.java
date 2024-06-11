package com.resort.Sunset.mapper;

import com.resort.Sunset.dto.img_all;
import com.resort.Sunset.dto.room;
import org.apache.ibatis.annotations.Mapper;

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
}
