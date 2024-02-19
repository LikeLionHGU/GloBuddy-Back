package com.likelion.GloBuddyBackend.controller.response.Member;

import com.likelion.GloBuddyBackend.dto.EnterSiteDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
@AllArgsConstructor
public class EnterMemberResponse {

    private Long memberId;
    private boolean registered;

    public EnterMemberResponse(EnterSiteDto dto) {
        this.memberId = dto.getMemberId();
        this.registered = dto.isRegistered();
    }
}
