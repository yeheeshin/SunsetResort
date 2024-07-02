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

    // 사용자 정보 업데이트
    public void updateUser(users user) {
        userMapper.updateUser(user);
    }

    // 회원 가입 시, 이메일 체크
    public String isDuplicateUser(users user) {
        users email = userMapper.selectByEmail(user.getEmail());
        users phone = userMapper.selectByPhone(user.getPhone());

        if (email != null) {
            return "이미 사용 중인 이메일 입니다.";
        } else if (phone != null) {
            return "이미 사용 중인 전화번호 입니다.";
        } else {
            return "";
        }
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
