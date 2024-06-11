package com.resort.Sunset.service;

import com.resort.Sunset.dto.amenities;
import com.resort.Sunset.dto.img_all;
import com.resort.Sunset.mapper.AmMapper;
import com.resort.Sunset.mapper.ImgAllMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ImgAllService {
    private final ImgAllMapper imgAllMapper;

    // 특정 id를 가진 객실의 이미지 가져오기
    public List<img_all> getRoomImg(Long room_id) {
        return imgAllMapper.selectByRoomId(room_id);
    }

    // 특정 id를 가진 객실의 이미지 가져오기
    public List<img_all> getResImg(Long res_id) {
        return imgAllMapper.selectByResId(res_id);
    }

    public List<img_all> getStoreImg(Long store_id) {
        return imgAllMapper.selectByStoreId(store_id);
    }
}
