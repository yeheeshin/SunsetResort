package com.resort.Sunset.mapper;

import com.resort.Sunset.dto.users;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    users selectByEmail(String email);

    users selectByPhone(String phone);

    void saveUser(users user);

    void updateUser(users user);

    List<users> selectAll();
}


