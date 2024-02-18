package com.likelion.GloBuddyBackend.controller.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MatchingRequest {
    private Long memberId;
    private String chatLink;
    private String message;

}
