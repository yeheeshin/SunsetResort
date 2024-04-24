package com.resort.Sunset.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class pro_reserveDTO {
    private Long pro_re_id;

    private int children;
    private LocalDate fin_date;
    private int people;
    private LocalDate start_date;

    private Long pro_id;
    private int user_id;

}
