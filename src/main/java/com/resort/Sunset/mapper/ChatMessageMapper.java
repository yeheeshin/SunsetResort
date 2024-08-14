package com.resort.Sunset.mapper;

import com.resort.Sunset.dto.ChatMessages;
import com.resort.Sunset.dto.amenities;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ChatMessageMapper {
    List<ChatMessages> findMessageByChatId(Long chat_id);

    void insertMessage(ChatMessages chatMessages);
}


