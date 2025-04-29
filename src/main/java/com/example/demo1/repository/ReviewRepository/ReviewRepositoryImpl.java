package com.example.demo1.repository.ReviewRepository;

import com.example.demo1.domain.*;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepositoryCustom {

    private final JPAQueryFactory queryFactory;
    private final EntityManager em;

    @Override
    @Transactional
    public Review saveReview(Long memberId, Long storeId, String body, Float score) {
        QMember qMember = QMember.member;
        QStore qStore = QStore.store;

        // 회원 조회
        Member member = queryFactory.selectFrom(qMember)
                .where(qMember.id.eq(memberId))
                .fetchOne();

        // 가게 조회
        Store store = queryFactory.selectFrom(qStore)
                .where(qStore.id.eq(storeId))
                .fetchOne();

        if (member == null || store == null) {
            throw new IllegalArgumentException("잘못된 memberId 또는 storeId입니다.");
        }

        // 리뷰 생성
        Review review = Review.builder()
                .member(member)
                .store(store)
                .body(body)
                .score(score)
                .build();

        // 저장
        em.persist(review);

        return review;
    }
}