package com.resort.Sunset.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class menuFile {
    private Long file_id;

    private String file_name;
    private String delete_flag;
    private String menu_name;

    private Long res_id;
}
