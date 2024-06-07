package com.resort.Sunset.mapper;

import com.resort.Sunset.dto.menuFile;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuFileMapper {
    // 레스토랑 id로 메뉴 파일 가져오기
    List<menuFile> selectByResId(Long res_id);
}


