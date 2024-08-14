package com.resort.Sunset.service;

import com.resort.Sunset.mapper.ChatMapper;
import com.resort.Sunset.mapper.ChatMessageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ChatService {
    private final ChatMapper chatMapper;

}
