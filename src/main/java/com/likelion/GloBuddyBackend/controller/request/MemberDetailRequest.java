package com.likelion.GloBuddyBackend.controller.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberDetailRequest {

    private Long memberId;
    private String gender;
    private String nation;

    private String mbti;




}
