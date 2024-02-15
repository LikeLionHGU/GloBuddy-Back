package com.likelion.GloBuddyBackend.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MatchingMemberDto {

    private Long senderId;
    private Long receiverId;

    private byte ifMatched;

    private boolean ifCheched;

}
