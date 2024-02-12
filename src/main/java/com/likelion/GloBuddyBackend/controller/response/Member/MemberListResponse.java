package com.likelion.GloBuddyBackend.controller.response.Member;


import com.likelion.GloBuddyBackend.dto.MemberDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
public class MemberListResponse {

    private List<MemberResponse> members;

    public MemberListResponse(List<MemberDto> members) {
        this.members = members.stream().map(MemberResponse::new).toList();
    }
}

