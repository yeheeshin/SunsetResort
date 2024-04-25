package com.resort.Sunset.dto;

import com.resort.Sunset.dto.enumType.Rview;
import com.resort.Sunset.dto.enumType.bed_type;
import com.resort.Sunset.dto.enumType.room_class;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class room {
    private Long room_id;

    private int area;
    private bed_type bed_type;
    private int max_people;
    private String name;
    private room_class room_class;
    private int room_count;
    private Rview view;
}
