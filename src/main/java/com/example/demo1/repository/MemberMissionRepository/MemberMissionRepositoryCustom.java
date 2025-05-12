package com.example.demo1.repository.MemberMissionRepository;

import com.example.demo1.domain.Mission;
import com.example.demo1.domain.enums.MissionStatus;

import java.util.List;

public interface MemberMissionRepositoryCustom {
    public List<Mission> getMissions (MissionStatus status);
}
