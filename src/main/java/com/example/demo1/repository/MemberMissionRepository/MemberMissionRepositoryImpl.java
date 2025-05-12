package com.example.demo1.repository.MemberMissionRepository;

import com.example.demo1.domain.Mission;
import com.example.demo1.domain.enums.MissionStatus;
import com.example.demo1.domain.mapping.QMemberMission;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.demo1.domain.QMission.mission;
@Repository
@RequiredArgsConstructor
public class MemberMissionRepositoryImpl implements MemberMissionRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;
    private final QMemberMission memberMission = QMemberMission.memberMission;

    @Override
    public List<Mission> getMissions (MissionStatus status) {
        BooleanBuilder predicate = new BooleanBuilder();

        if (status != null) {
            predicate.and(memberMission.status.eq(status));
        }

        return jpaQueryFactory
                .selectFrom(mission)
                .where(predicate)
                .fetch();


    }
}
