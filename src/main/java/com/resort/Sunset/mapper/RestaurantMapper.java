package com.resort.Sunset.mapper;

import com.resort.Sunset.dto.restaurant;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RestaurantMapper {
    // 모든 정보 가져오기
    List<restaurant> selectAll();

    // id로 레스토랑 정보 가져오기
    restaurant selectResId(Long res_id);
}


