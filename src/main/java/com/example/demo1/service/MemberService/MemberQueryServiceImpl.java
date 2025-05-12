package com.example.demo1.service.MemberService;

import com.example.demo1.domain.Member;
import com.example.demo1.repository.memberRepository.MemberRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberQueryServiceImpl implements MemberQueryService {

    private final MemberRepository memberRepository;

    @Override
    public Optional<Member> findMyInfo(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
