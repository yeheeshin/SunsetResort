package com.resort.Sunset.mapper;

import com.resort.Sunset.dto.amenities;
import com.resort.Sunset.dto.ranking;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RankMapper {

    public ranking selectByRankId(Long rank_id);

    public List<ranking> selectAll();
}


