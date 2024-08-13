package com.resort.Sunset.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class ChatMessages {
    private Long cm_id;

    private String message;
    private LocalDateTime created_at;

    private Long chat_id;
    private Long au_id;
}
