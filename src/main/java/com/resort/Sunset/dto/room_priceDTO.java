package com.resort.Sunset.dto;

import com.resort.Sunset.dto.enumType.diff;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class room_priceDTO {
    private Long price_id;
    private int price;
    private diff diff;

    private Long room_id;
}
