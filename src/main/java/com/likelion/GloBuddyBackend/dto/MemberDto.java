package com.likelion.GloBuddyBackend.dto;

import com.likelion.GloBuddyBackend.domain.Member;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MemberDto {


    private Long memberId;

    private String name;

    private String email;

    private String image;

    public static MemberDto of(Member member){
    return MemberDto.builder()
        .memberId(member.getMemberId())
        .name(member.getName())
        .email(member.getEmail())
        .image(member.getImage())
        .build();
    }

}
