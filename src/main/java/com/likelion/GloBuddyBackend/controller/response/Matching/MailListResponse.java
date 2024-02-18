package com.likelion.GloBuddyBackend.controller.response.Matching;

import com.likelion.GloBuddyBackend.controller.response.ApiResponse;
import com.likelion.GloBuddyBackend.dto.MatchingMemberDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
public class MailListResponse extends ApiResponse {

    private List<MailResponse> receiveMailResponseList;


    public MailListResponse(List<MatchingMemberDto> matching) {
        this.receiveMailResponseList = matching.stream().map(MailResponse::new).toList();
    }


}
