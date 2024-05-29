package com.resort.Sunset.mapper;

import com.resort.Sunset.dto.amenities;
import com.resort.Sunset.dto.promotion;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PromotionMapper {
    // 모든 프로모션 가져오기
    List<promotion> selectAll();
}


