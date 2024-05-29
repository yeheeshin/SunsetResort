package com.resort.Sunset.mapper;

import com.resort.Sunset.dto.store;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StoreMapper {
    // 모든 정보 가져오기
    List<store> selectAll();
}


