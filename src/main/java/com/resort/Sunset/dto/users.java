package com.resort.Sunset.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class users {
    private Long user_id;

    private String email;
    private String name;
    private String phone;
    private String pwd;
    private int point;

    private Long rank_id;
}
