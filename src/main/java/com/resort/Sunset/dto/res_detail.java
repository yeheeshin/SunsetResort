package com.resort.Sunset.dto;

import com.resort.Sunset.dto.enumType.time_category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class res_detail {
    private Long res_detail_id;

    private String content;
    private time_category time_category;
    private String title;
}
