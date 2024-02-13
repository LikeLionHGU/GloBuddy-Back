package com.likelion.GloBuddyBackend.service;

import com.likelion.GloBuddyBackend.domain.Member;
import com.likelion.GloBuddyBackend.domain.MemberDetail;
import com.likelion.GloBuddyBackend.dto.MemberDetailDto;
import com.likelion.GloBuddyBackend.dto.MemberDto;
import com.likelion.GloBuddyBackend.exception.MemberNotFoundException;
import com.likelion.GloBuddyBackend.repository.MemberDetailRepository;
import com.likelion.GloBuddyBackend.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.likelion.GloBuddyBackend.domain.MemberDetail.toMemberDetail;

@Service
@RequiredArgsConstructor
public class MemberDetailService {

    private final MemberDetailRepository memberDetailRepository;
    private final MemberRepository memberRepository;

    public Long addMemberDetail(MemberDetailDto dto) {

        Member member = memberRepository.findById(dto.getMemberId()).orElseThrow(MemberNotFoundException::new);
        MemberDetail memberDetail = MemberDetail.create(dto,member);
        MemberDetail saved = memberDetailRepository.save(memberDetail);

        return saved.getMemberDetailId();
    }

    public MemberDetailDto getMemberDetails(Long memberId) {

        MemberDetail memberDetail = memberDetailRepository.findById(memberId).orElseThrow(MemberNotFoundException::new);
        return MemberDetailDto.of(memberDetail);

    }


    public void editMemberDetail(MemberDetailDto dto, Long memberId) {
        MemberDetail memberDetail = memberDetailRepository.findById(memberId).orElseThrow(MemberNotFoundException::new);
        memberDetail.update(dto);
    }


}

