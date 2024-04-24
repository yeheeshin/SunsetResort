package com.resort.Sunset.dto;

import com.resort.Sunset.dto.enumType.time_category;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter @Setter
public class res_reserveDTO {
    private Long reres_id;

    private String add_request;
    private int children;
    private int people;
    private LocalDate res_date;
    private LocalDateTime res_time;
    private time_category time_category;

    private Long res_id;
    private Long user_id;

}
