package com.resort.Sunset.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
public class room_reserve {
    private Long re_id;

    private String add_request;
    private int child;
    private LocalDate in_date;
    private LocalDate out_date;
    private int people;

    private Long room_id;
    private Long user_id;
}
