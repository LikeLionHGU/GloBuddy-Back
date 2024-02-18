package com.likelion.GloBuddyBackend.service;

import com.likelion.GloBuddyBackend.domain.Member;
import com.likelion.GloBuddyBackend.domain.MemberDetail;
import com.likelion.GloBuddyBackend.dto.MemberDto;
import com.likelion.GloBuddyBackend.dto.MemberInfoEditDto;
import com.likelion.GloBuddyBackend.exception.MemberNotFoundException;
import com.likelion.GloBuddyBackend.repository.MemberDetailRepository;
import com.likelion.GloBuddyBackend.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MypageService {

    private final MemberRepository memberRepository;
    private final MemberDetailRepository memberDetailRepository;


    @Transactional
    public void editMemberInfo(MemberInfoEditDto dto, Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(MemberNotFoundException::new);
        MemberDetail memberDetail = memberDetailRepository.findAllByMember(memberId);

        member.nameUpdate(dto);
        memberDetail.infoUpdate(dto);

    }
}
