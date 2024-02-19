package com.likelion.GloBuddyBackend.controller.response.Matching;

import com.likelion.GloBuddyBackend.controller.response.ApiResponse;
import com.likelion.GloBuddyBackend.dto.MatchingMemberDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
public class RequestMatchingListResponse extends ApiResponse {


    private List<RequestMatchingResponse> receiveMailResponseList;

    public RequestMatchingListResponse(List<MatchingMemberDto> matching) {
        this.receiveMailResponseList = matching.stream().map(RequestMatchingResponse::new).toList();
    }

}
