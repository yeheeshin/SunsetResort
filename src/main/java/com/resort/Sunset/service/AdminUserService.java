package com.resort.Sunset.service;

import com.resort.Sunset.dto.admin_user;
import com.resort.Sunset.mapper.AuMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class AdminUserService {
    private final AuMapper auMapper;

    public admin_user findByauId(Long au_id) {
        return auMapper.selectByAuId(au_id);
    }
}
