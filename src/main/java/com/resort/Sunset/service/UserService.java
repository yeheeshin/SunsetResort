package com.resort.Sunset.service;

import com.resort.Sunset.dto.users;
import com.resort.Sunset.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper;

    // id로 유저 정보 가져오기
    public users getUser(String email) {
        return userMapper.selectByEmail(email);
    }

    // 회원가입
    public void saveUser(users user) {
        userMapper.saveUser(user);
    }

    public users nowUser() {
        // 현재 사용자 정보
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();

        if (userMapper.selectByEmail(name) == null) {
            throw new IllegalStateException("로그인 해라");
        }

        return userMapper.selectByEmail(name);
    }
}
