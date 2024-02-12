package com.likelion.GloBuddyBackend.service;

import com.likelion.GloBuddyBackend.domain.MemberDetail;
import com.likelion.GloBuddyBackend.dto.MemberDetailDto;
import com.likelion.GloBuddyBackend.exception.MemberNotFoundException;
import com.likelion.GloBuddyBackend.repository.MemberDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberDetailService {

    private final MemberDetailRepository memberDetailRepository;


    public Long addMemberDetail(MemberDetailDto dto) {
        MemberDetail memberDetail = MemberDetail.create(dto);
        MemberDetail saved = memberDetailRepository.save(memberDetail);

        return saved.getMemberDetailId();
    }

    public List<MemberDetailDto> getAllMemberDetails() {
        List<MemberDetail> memberDetails = memberDetailRepository.findAll();
        return memberDetails.stream().map(MemberDetailDto::of).toList();
    }

    public void editMemberDetail(MemberDetailDto dto, Long memberDetailId) {
        MemberDetail memberDetail = memberDetailRepository.findById(memberDetailId).orElseThrow(MemberNotFoundException::new);
        memberDetail.update(dto);
    }

    public void deleteDetail(Long memberDetailId) {
        memberDetailRepository.deleteById(memberDetailId);
    }

}

