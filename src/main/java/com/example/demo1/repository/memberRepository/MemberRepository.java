package com.example.demo1.repository.memberRepository;

import com.example.demo1.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
