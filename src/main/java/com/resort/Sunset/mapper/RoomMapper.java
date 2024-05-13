package com.resort.Sunset.mapper;

import com.resort.Sunset.dto.room;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoomMapper {
    List<room> allRoom();

    room selectById(Long rid);

    room fileUpload(String fileName);

    // 객실이 가지고 있는 침대타입 이름들
    List<String> duplicateBed(Long rid);

    // 객실이 가지고 있는 전망 이름들
    List<String> duplicateView(Long rid);
}
