package com.example.demo1.repository.MemberMissionRepository;

import com.example.demo1.domain.Member;
import com.example.demo1.domain.Mission;
import com.example.demo1.domain.enums.MissionStatus;
import com.example.demo1.domain.mapping.MemberMission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {
    boolean existsByMissionIdAndMemberIdAndStatus(Long missionId, Long memberId, MissionStatus status);


    @Query("""
        SELECT mm.mission
        FROM MemberMission mm
        WHERE mm.member = :member
        AND mm.status = :status
    """)
    Page<Mission> findMissionsByMemberAndStatus(@Param("member") Member member,
                                                @Param("status") MissionStatus status,
                                                Pageable pageable);
}