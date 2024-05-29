package com.resort.Sunset.service;

import com.resort.Sunset.dto.restaurant;
import com.resort.Sunset.mapper.RestaurantMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class RestaurantService {
    private final RestaurantMapper restaurantMapper;

    // 모든 정보 조회
    public List<restaurant> selectAll() {
        return restaurantMapper.selectAll();
    }
}


