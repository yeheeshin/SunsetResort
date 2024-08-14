package com.resort.Sunset.mapper;

import com.resort.Sunset.dto.ChatMessages;
import com.resort.Sunset.dto.amenities;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ChatMessageMapper {
    ChatMessages selectAll();
}


