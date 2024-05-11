package com.resort.Sunset.mapper;

import com.resort.Sunset.dto.amenities;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AmMapper {
    // id로 어메니티 정보 가져오기
    amenities selectByAmId(Long amid);
}


