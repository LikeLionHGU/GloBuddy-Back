package com.likelion.GloBuddyBackend.repository;

import com.likelion.GloBuddyBackend.domain.MatchingMember;
import com.likelion.GloBuddyBackend.domain.Member;
import com.likelion.GloBuddyBackend.domain.MemberDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface MatchingMemberRepository extends JpaRepository<MatchingMember, Long> {


//    수신 : 본인
    @Query("select m from MatchingMember m where( m.post.member =:receiver and m.IfMatched = 0) OR ( m.member =:receiver and m.IfMatched !=0)")
    List<MatchingMember> findAllByMemberIdAndIfNotMatched(Member receiver);

// 송신 : 본인 * 읽음 표시 클릭 안 했을 때
    @Query("select m from MatchingMember m where m.member =:sender  and m.IfChecked = false ")
    List<MatchingMember> findAllByMemberIdAndIfNotChecked(Member sender);


    //    받은 알림 개수 ( 받는 사람 : 본인 && 미확인 )
    @Query("select count(*) from MatchingMember m where m.post.member =:receiver and m.IfMatched = 0")
    long getNumOfReceiveMail(Member receiver);


    //    보낸 알림 개수 ( 보낸 사람 : 본인 && Checked 안 한 거 )
    @Query("select count(*) from MatchingMember m where m.member =:sender  and m.IfChecked = false ")
    long getNumOfSentMail(Member sender);

    MatchingMember findByMember(Member member);


}
