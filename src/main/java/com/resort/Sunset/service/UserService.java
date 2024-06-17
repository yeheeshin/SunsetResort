package com.resort.Sunset.service;

import com.resort.Sunset.dto.users;
import com.resort.Sunset.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    // id로 유저 정보 가져오기
    public users getUser(String email) {
        return userMapper.selectByEmail(email);
    }

    // 회원가입
    public void saveUser(users user) {
        user.setPwd(passwordEncoder.encode(user.getPwd()));
        userMapper.saveUser(user);
    }
}
