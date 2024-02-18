package com.likelion.GloBuddyBackend.repository;

import com.likelion.GloBuddyBackend.domain.MatchingMember;
import com.likelion.GloBuddyBackend.domain.Member;
import com.likelion.GloBuddyBackend.domain.MemberDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface MatchingMemberRepository extends JpaRepository<MatchingMember, Long> {

    @Query("select m from MatchingMember m where m.post.member =:receiver and m.IfMatched = 0 ")
    List<MatchingMember> findAllByMemberIdAndIfNotMatched(Member receiver);


    @Query("select m from MatchingMember m where m.member =:sender  and m.IfChecked = false ")
    List<MatchingMember> findAllByMemberIdAndIfNotChecked(Member sender);


    //    받은 알림 개수 ( 받는 사람 : 본인 && 미확인 )
    @Query("select count(*) from MatchingMember m where m.post.member =:receiver and m.IfMatched = 0")
    long getNumOfReceiveMail(Member receiver);


    //    보낸 알림 개수 ( 보낸 사람 : 본인 && Checked 안 한 거 )
    @Query("select count(*) from MatchingMember m where m.member =:sender  and m.IfChecked = false ")
    long getNumOfSentMail(Member sender);


}
