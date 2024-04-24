package com.resort.Sunset.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class store_reserve {
    private Long store_re_id;

    private int children;
    private int people;
    private LocalDate re_date;

    private Long store_id;
}
