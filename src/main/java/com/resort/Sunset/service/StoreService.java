package com.resort.Sunset.service;

import com.resort.Sunset.dto.store;
import com.resort.Sunset.mapper.StoreMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class StoreService {
    private final StoreMapper storeMapper;

    // 모든 정보 조회
    public List<store> selectAll() {
        return storeMapper.selectAll();
    }

    // id로 부대시설 상세페이지 조회
    public store getStore(Long store_id) {
        return storeMapper.selectByStoreId(store_id);
    }

    // 3개 부대시설 정보 가져오기
    public List<store> getTop() {
        return storeMapper.selectByTop();
    }
}


