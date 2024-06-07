package com.resort.Sunset.service;

import com.resort.Sunset.dto.menuFile;
import com.resort.Sunset.mapper.MenuFileMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MenuFileService {
    private final MenuFileMapper menuFileMapper;

    // 레스토랑의 메뉴 가져오기
    public List<menuFile> getMenuByRes(Long res_id) {
        return menuFileMapper.selectByResId(res_id);
    }
}
