package com.likelion.GloBuddyBackend.dto;

import com.likelion.GloBuddyBackend.domain.MemberDetail;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MemberDetailDto {

    private Long memberDetailId;


    private String gender;
    private String nation;
    private int numNotification;


    public static MemberDetailDto of(MemberDetail memberDetail){
        return MemberDetailDto.builder()
                .memberDetailId(memberDetail.getMemberDetailId())
                .gender(memberDetail.getGender())
                .nation(memberDetail.getNation())
                .numNotification(memberDetail.getNumNotification())
                .build();
    }
}
