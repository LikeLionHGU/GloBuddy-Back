package com.likelion.GloBuddyBackend.dto;

import com.likelion.GloBuddyBackend.controller.request.MemberRequest;
import com.likelion.GloBuddyBackend.domain.Member;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MemberDto {


    private Long memberId;

    private String name;

    private String email;

    private String picture;

    public static MemberDto of(Member member){
    return MemberDto.builder()
        .memberId(member.getMemberId())
        .name(member.getName())
        .email(member.getEmail())
        .picture(member.getPicture())
        .build();
    }


    public static MemberDto of(MemberRequest memberRequest){
        return MemberDto.builder()
                .name(memberRequest.getName())
                .email(memberRequest.getEmail())
                .picture(memberRequest.getPicture())
                .build();

    }

}
