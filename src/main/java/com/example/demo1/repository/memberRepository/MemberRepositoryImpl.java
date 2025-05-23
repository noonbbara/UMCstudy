package com.example.demo1.repository.memberRepository;

import com.example.demo1.domain.Member;
import com.example.demo1.domain.QMember;
import com.example.demo1.domain.QStore;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;
    private final QMember member = QMember.member;

    @Override
    public Member myPage(Long memberId){
        BooleanBuilder predicate = new BooleanBuilder();

        if (memberId != null) {
            predicate.and(member.id.eq(memberId));
        }

        return jpaQueryFactory
                .selectFrom(member)
                .where(predicate)
                .fetchOne();

    }
}
