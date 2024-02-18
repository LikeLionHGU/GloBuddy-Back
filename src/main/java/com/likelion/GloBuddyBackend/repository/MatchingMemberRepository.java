package com.likelion.GloBuddyBackend.repository;

import com.likelion.GloBuddyBackend.domain.MatchingMember;
import com.likelion.GloBuddyBackend.domain.Member;
import com.likelion.GloBuddyBackend.domain.MemberDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MatchingMemberRepository  extends JpaRepository<MatchingMember, Long> {

//    //    미확인인 거 가져오기 ( receiverid가 본인 id와 같고 && Ifmatched가 0인 것 )
//    @Query("select m from MatchingMember m where m.post.member =:receiver  and m.IfMatched = 0 ")
//    MatchingMember findAllByMemberIdAndIfMatched(Member receiver);
//
//
//
//    //    안 읽은 거 가져오기  ( senderid가 본인 id와 같고 && IfChecked가 false인 것 )
//    @Query("select m from MatchingMember m where m.post.member.memberId =:memberId and m.IfChecked = false ")
//    MatchingMember findAllByMemberIdAndIfChecked(Long senderId);



}
