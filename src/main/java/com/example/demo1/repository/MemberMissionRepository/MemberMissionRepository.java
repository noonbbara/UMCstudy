package com.example.demo1.repository.MemberMissionRepository;

import com.example.demo1.domain.mapping.MemberMission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {
}
