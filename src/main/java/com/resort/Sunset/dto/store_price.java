package com.resort.Sunset.dto;

import com.resort.Sunset.dto.enumType.diff;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class store_price {
    private Long s_price_id;

    private diff diff;
    private int s_price;
}
