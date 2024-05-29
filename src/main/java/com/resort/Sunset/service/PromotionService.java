package com.resort.Sunset.service;

import com.resort.Sunset.dto.promotion;
import com.resort.Sunset.mapper.PromotionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PromotionService {
    private final PromotionMapper promotionMapper;

    // 모든 정보 조회
    public List<promotion> selectAll() {
        return promotionMapper.selectAll();
    }
}


