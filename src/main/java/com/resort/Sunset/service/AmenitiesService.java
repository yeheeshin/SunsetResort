package com.resort.Sunset.service;

import com.resort.Sunset.dto.amenities;
import com.resort.Sunset.mapper.AmMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class AmenitiesService {
    private final AmMapper amMapper;

    public amenities getAmenities(Long amid) {
        return amMapper.selectByAmId(amid);
    }
}
