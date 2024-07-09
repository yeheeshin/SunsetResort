package com.resort.Sunset.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ranking {
    private Long rank_id;

    private String rank_name;
    private int points_required;
    private int save_point;
}
