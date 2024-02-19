package com.likelion.GloBuddyBackend.service;

import com.likelion.GloBuddyBackend.domain.Member;
import com.likelion.GloBuddyBackend.dto.EnterSiteDto;
import com.likelion.GloBuddyBackend.dto.MemberDto;
import com.likelion.GloBuddyBackend.exception.MemberNotFoundException;
import com.likelion.GloBuddyBackend.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public EnterSiteDto addMember(MemberDto dto) {
        Member member = Member.create(dto);
        EnterSiteDto registered = new EnterSiteDto();

        if (memberRepository.existsByEmail(dto.getEmail())) {
            Long memberId = memberRepository.findByEmail(dto.getEmail()).getMemberId();
            registered.setMemberId(memberId);
            registered.setRegistered(true);
        }
        else {
            Member saved = memberRepository.save(member);
            registered.setMemberId(saved.getMemberId());
            registered.setRegistered(false);

        }
        return registered;
    }

    public List<MemberDto> getAllMembers() {
        List<Member> members = memberRepository.findAll();
        return members.stream().map(MemberDto::of).toList();
    }

    public MemberDto getMember(Long memberId){
        Member member = memberRepository.findById(memberId).orElseThrow(MemberNotFoundException::new);
        return MemberDto.of(member);
    }

    @Transactional
    public void editMember(MemberDto dto, Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(MemberNotFoundException::new);
        member.update(dto);
    }


    public void delete(Long memberId) {
        memberRepository.deleteById(memberId);
    }

}
