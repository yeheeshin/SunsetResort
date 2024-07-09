package com.resort.Sunset.service;

import com.resort.Sunset.dto.amenities;
import com.resort.Sunset.dto.ranking;
import com.resort.Sunset.mapper.AmMapper;
import com.resort.Sunset.mapper.RankMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class RankService {
    private final RankMapper rankMapper;

    // id로 rank 조회
    public ranking getRanking(Long rank_id) {
        return rankMapper.selectByRankId(rank_id);
    }

    public List<ranking> getAll() {
        return rankMapper.selectAll();
    }
}
