package com.resort.Sunset.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Getter @Setter
public class store {
    private Long store_id;

    private LocalTime close_time;
    private String content;
    private String intro;
    private String location;
    private String name;
    private LocalTime open_time;
    private String store_type;
}
