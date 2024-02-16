package com.likelion.GloBuddyBackend.controller.response.Matching;

import com.likelion.GloBuddyBackend.controller.response.ApiResponse;
import com.likelion.GloBuddyBackend.controller.response.Member.MemberResponse;
import com.likelion.GloBuddyBackend.dto.MatchingMemberDto;
import com.likelion.GloBuddyBackend.dto.MemberDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Getter
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
public class ReceiveMailListResponse extends ApiResponse {

    private List<ReceiveMailResponse> receiveMailResponseList;


    public ReceiveMailListResponse(List<MatchingMemberDto> matching) {
        this.receiveMailResponseList = matching.stream().map(ReceiveMailResponse::new).toList();
    }


}
