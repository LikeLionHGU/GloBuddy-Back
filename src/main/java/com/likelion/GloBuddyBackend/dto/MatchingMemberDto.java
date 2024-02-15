package com.likelion.GloBuddyBackend.dto;

import com.likelion.GloBuddyBackend.controller.request.MemberDetailRequest;
import com.likelion.GloBuddyBackend.domain.Member;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MatchingMemberDto {

    private Long senderId;
    private Long receiverId;

    private byte ifMatched;

    private boolean ifChecked;


    public static MatchingMemberDto of(Member sender, Member receiver) {

        return MatchingMemberDto.builder()
                .senderId(sender.getMemberId())
                .receiverId(receiver.getMemberId())
                .build();
    }
}
