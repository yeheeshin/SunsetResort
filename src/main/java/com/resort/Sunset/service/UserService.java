package com.resort.Sunset.service;

import com.resort.Sunset.dto.ranking;
import com.resort.Sunset.dto.users;
import com.resort.Sunset.mapper.RankMapper;
import com.resort.Sunset.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper;
    private final RankMapper rankMapper;

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

    // 주문 시, 포인트 적립 & 등급 조정
    public void orderPoint(users user, int total_price) {
        Long rankId = user.getRank_id();

        ranking rank = rankMapper.selectByRankId(rankId);
        int savePoint = rank.getSave_point();

        // 가격에 따른 포인트 적립 계산해서 원래 포인트 + 적립할 포인트
         int point_save = (int)(total_price *(savePoint/100.0));
         user.setPoint(point_save + user.getPoint());

        int point = user.getPoint();
        List<ranking> rankings = rankMapper.selectAll();

        // 포인트 점수에 따른 등급 조정
        for (ranking ranking : rankings) {
            if (point > ranking.getPoints_required()) {
                user.setRank_id(ranking.getRank_id());
            }
        }
        System.out.println((savePoint/100.0) + " 몽총이");

        userMapper.updateUser(user);
    }

    public users nowUser() {
        // 현재 사용자 정보
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();

        return userMapper.selectByEmail(name);
    }

    // 모든 회원 조회
    public List<users> userAll() {
        return userMapper.selectAll();
    }
}
