package com.resort.Sunset.mapper;

import com.resort.Sunset.dto.img_all;
import com.resort.Sunset.dto.room;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ImgAllMapper {
    // id로 객실 이미지 가져오기
    List<img_all> selectByRoomId(Long room_id);

    // 객실 이미지 전체 가져오기
    List<img_all> selectAllRoomImg();
}


