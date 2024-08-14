package com.resort.Sunset.mapper;

import com.resort.Sunset.dto.ChatMessages;
import com.resort.Sunset.dto.ChatRooms;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ChatMapper {

    void insertChat(ChatRooms chatRooms);

    List<ChatRooms> selectAllByUserId(Long au_id);
}


