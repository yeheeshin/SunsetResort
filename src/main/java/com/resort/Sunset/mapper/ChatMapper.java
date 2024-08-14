package com.resort.Sunset.mapper;

import com.resort.Sunset.dto.ChatMessages;
import com.resort.Sunset.dto.ChatRooms;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ChatMapper {
    ChatRooms selectAll();
}


