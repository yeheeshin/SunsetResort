package com.resort.Sunset.service;

import com.resort.Sunset.dto.room;
import com.resort.Sunset.mapper.RoomMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class RoomService {
    private final RoomMapper roomMapper;

    public room getRoom(Long rid) {
        return roomMapper.selectById(rid);
    }
}
