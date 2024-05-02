package com.resort.Sunset.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class promotion {
    private Long pro_id;

    private String content;
    private LocalDate fin_date;
    private String name;
    private int sale;
    private LocalDate start_date;

    private Long res_id;
    private Long room_id;
    private Long store_id;
}
