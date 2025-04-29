package com.example.demo1.service.MemberService;

import com.example.demo1.domain.Member;

import java.util.Optional;

public interface MemberQueryService {
    Optional<Member> findMyInfo(Long memberId);
}
