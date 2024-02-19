package com.likelion.GloBuddyBackend.repository;

import com.likelion.GloBuddyBackend.domain.Member;
import com.likelion.GloBuddyBackend.domain.MemberDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MemberDetailRepository extends JpaRepository<MemberDetail, Long> , JpaSpecificationExecutor<Member> {

  @Query("select m from MemberDetail m where m.member.memberId= :memberId")
  MemberDetail findAllByMember(Long memberId);

  @Query("select m from MemberDetail m where m.member.memberId = :sender")
  MemberDetail findAllByMemberforInfo(Member sender);
}

