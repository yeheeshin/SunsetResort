package com.resort.Sunset.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class restaurant {
    private Long res_id;

    private String content;
    private String intro;
    private String location;
    private String name;
    private String type;

    private Long res_detail_id;
}
