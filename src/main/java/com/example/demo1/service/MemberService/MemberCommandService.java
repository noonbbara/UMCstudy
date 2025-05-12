package com.example.demo1.service.MemberService;

import com.example.demo1.domain.Member;
import com.example.demo1.dto.requestdto.MemberRequestDTO;

public interface MemberCommandService {
    Member joinMember(MemberRequestDTO.JoinDto request);
}
