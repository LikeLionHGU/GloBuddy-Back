package com.likelion.GloBuddyBackend.repository;

import com.likelion.GloBuddyBackend.domain.Member;
import com.likelion.GloBuddyBackend.domain.QMember;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long>  {

}
