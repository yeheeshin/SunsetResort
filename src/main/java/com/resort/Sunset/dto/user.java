package com.resort.Sunset.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class user {
    private Long user_id;

    private LocalDate birth;
    private String email;
    private String name;
    private String phone;
    private String pwd;
}
