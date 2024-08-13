package com.resort.Sunset.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class ChatRooms {
    private Long chat_id;
    private String chat_name;
    private LocalDateTime created_at;
}
