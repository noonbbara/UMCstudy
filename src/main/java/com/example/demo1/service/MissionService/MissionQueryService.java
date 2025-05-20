package com.example.demo1.service.MissionService;

import com.example.demo1.domain.Mission;
import org.springframework.data.domain.Page;

public interface MissionQueryService {
    Page<Mission> getChallengingMissionList(Long memberId, Integer page);
}