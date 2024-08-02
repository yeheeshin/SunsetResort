package com.resort.Sunset.mapper;

import com.resort.Sunset.dto.admin_user;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AuMapper {
    admin_user selectByAuId(Long au_id);

    List<admin_user> selectAll();

    void saveAdmin(admin_user adminUser);
}


