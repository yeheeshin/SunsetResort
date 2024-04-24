package com.resort.Sunset.dto;

import com.resort.Sunset.dto.enumType.diff;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class room_price {
    private Long price_id;

    private diff diff;
    private int price;

    private Long room_id;
}
