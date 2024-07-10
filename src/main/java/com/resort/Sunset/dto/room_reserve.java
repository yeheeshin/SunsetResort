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
    private int breakfast;
    private int room_count;
    private int total_price;
    private String res_name;
    private String res_num;
    private String res_email;

    private Long room_id;
    private Long user_id;
}
