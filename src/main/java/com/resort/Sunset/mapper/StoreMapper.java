package com.resort.Sunset.mapper;

import com.resort.Sunset.dto.store;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StoreMapper {
    // 모든 정보 가져오기
    List<store> selectAll();

    // id로 부대시설 상세 페이지 가져오기
    store selectByStoreId(Long store_id);

    // 3개의 부대시설 정보 가져오기
    List<store> selectByTop();
}


