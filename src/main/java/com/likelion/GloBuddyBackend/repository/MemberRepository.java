package com.likelion.GloBuddyBackend.repository;

import com.likelion.GloBuddyBackend.domain.Member;
import com.likelion.GloBuddyBackend.domain.QMember;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long>  {

//    private final JPAQueryFactory query; //
//    private final QMember member = QMember.member; // 멤버

//    public List<Member> findAll(PostSearchFilter filter, Member member, long offset, int limit) {
//        return query
//                .selectFrom(member)
//                .where()
//                .fetch();
//    }


}
