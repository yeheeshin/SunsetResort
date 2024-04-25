package com.resort.Sunset.mapper;

import com.resort.Sunset.dto.room;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoomMapper {
    room selectById(Long rid);
}
