package com.resort.Sunset.service;

import com.resort.Sunset.dto.ChatMessages;
import com.resort.Sunset.mapper.ChatMessageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ChatMessageService {
    private final ChatMessageMapper chatMessageMapper;

    public List<ChatMessages> findByChatId(Long chat_id) {
        return chatMessageMapper.findMessageByChatId(chat_id);
    }

    public void sendMessage(ChatMessages chatMessages) {
        chatMessageMapper.insertMessage(chatMessages);
    }
}
