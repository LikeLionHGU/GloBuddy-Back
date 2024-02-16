package com.likelion.GloBuddyBackend.repository;

import com.likelion.GloBuddyBackend.domain.MatchingMember;
import com.likelion.GloBuddyBackend.domain.Member;
import com.likelion.GloBuddyBackend.domain.MemberDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MatchingMemberRepository extends JpaRepository<MatchingMember, Long> {

    //    미확인인 거 가져오기 ( receiverid가 본인 id와 같고 && Ifmatched가 0인 것 )
    @Query("select m from MatchingMember m where m.member =:receiver and m.IfChecked = false ")
    List<MatchingMember> findAllByMemberIdAndIfNotMatched(Member receiver);


    @Query("select m from MatchingMember m where m.post.member =:sender  and m.IfMatched = 0 ")
    List<MatchingMember> findAllByMemberIdAndIfNotChecked(Member sender);


}
