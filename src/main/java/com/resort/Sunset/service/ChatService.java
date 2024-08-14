package com.resort.Sunset.service;

import com.resort.Sunset.dto.ChatRooms;
import com.resort.Sunset.mapper.ChatMapper;
import com.resort.Sunset.mapper.ChatMessageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ChatService {
    private final ChatMapper chatMapper;

    public List<ChatRooms> findAllByUserId(Long au_id) {
        return chatMapper.selectAllByUserId(au_id);
    }

    public void createChat(ChatRooms chatRooms) {
        chatMapper.insertChat(chatRooms);
    }

}
