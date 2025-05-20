package com.example.demo1.service.MissionService;

import com.example.demo1.apiPayload.code.status.ErrorStatus;
import com.example.demo1.apiPayload.exception.GeneralException;
import com.example.demo1.domain.Member;
import com.example.demo1.domain.Mission;
import com.example.demo1.domain.enums.MissionStatus;
import com.example.demo1.repository.MemberMissionRepository.MemberMissionRepository;
import com.example.demo1.repository.memberRepository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MissionQueryServiceImpl implements MissionQueryService {
    private final MemberRepository memberRepository;
    private final MemberMissionRepository memberMissionRepository;

    @Override
    public Page<Mission> getChallengingMissionList(Long memberId, Integer page){
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new GeneralException(ErrorStatus.MEMBER_NOT_FOUND));

        Page<Mission> missionPage = memberMissionRepository.findMissionsByMemberAndStatus(member, MissionStatus.CHALLENGING, PageRequest.of(page, 10));
        return missionPage;
    }

}