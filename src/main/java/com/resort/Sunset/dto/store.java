package com.resort.Sunset.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class store {
    private Long store_id;

    private LocalDateTime close_time;
    private String content;
    private String intro;
    private String location;
    private String name;
    private LocalDateTime open_time;
    private String store_type;
}
