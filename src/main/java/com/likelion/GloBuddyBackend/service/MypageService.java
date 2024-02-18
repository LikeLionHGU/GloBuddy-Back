package com.likelion.GloBuddyBackend.service;

import com.likelion.GloBuddyBackend.domain.Member;
import com.likelion.GloBuddyBackend.domain.MemberDetail;
import com.likelion.GloBuddyBackend.dto.MyInfoEditDto;
import com.likelion.GloBuddyBackend.exception.MemberNotFoundException;
import com.likelion.GloBuddyBackend.repository.MemberDetailRepository;
import com.likelion.GloBuddyBackend.repository.MemberRepository;
import com.likelion.GloBuddyBackend.repository.PostRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MypageService {

    private final MemberRepository memberRepository;
    private final MemberDetailRepository memberDetailRepository;
    private final PostRepository postRepository;

    @Transactional
    public void editMemberInfo(MyInfoEditDto dto, Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(MemberNotFoundException::new);
        MemberDetail memberDetail = memberDetailRepository.findAllByMember(memberId);

        member.nameUpdate(dto);
        memberDetail.infoUpdate(dto);
    }


    // 본인 게시물 확인 service 로직 ▼


}
