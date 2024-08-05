package com.resort.Sunset.service;

import com.resort.Sunset.dto.admin_user;
import com.resort.Sunset.mapper.AuMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class AdminUserService {
    private final AuMapper auMapper;

    public admin_user findByauId(Long au_id) {
        return auMapper.selectByAuId(au_id);
    }

    public void saveAdmin(admin_user adminUser) {
        auMapper.saveAdmin(adminUser);
    }

    public List<admin_user> findAll() {
        return auMapper.selectAll();
    }

    public void updateAdmin(admin_user adminUser) {
        auMapper.updateAdmin(adminUser);
    }
}
