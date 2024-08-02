package com.resort.Sunset.mapper;

import com.resort.Sunset.dto.admin_user;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AuMapper {
    admin_user selectByAuId(Long au_id);
}


