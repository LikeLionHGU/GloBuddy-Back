package com.likelion.GloBuddyBackend.controller;

import com.likelion.GloBuddyBackend.controller.request.MatchingRequest;
import com.likelion.GloBuddyBackend.controller.response.ApiResponse;
import com.likelion.GloBuddyBackend.controller.response.Matching.ReceiveMailListResponse;
import com.likelion.GloBuddyBackend.controller.response.Matching.RequestMatchingResponse;
import com.likelion.GloBuddyBackend.domain.MatchingMember;
import com.likelion.GloBuddyBackend.dto.MatchingMemberDto;
import com.likelion.GloBuddyBackend.service.MatchingMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matching")
@RequiredArgsConstructor
public class MatchingMemberController {

    private final MatchingMemberService matchingService;


    @PostMapping("/{receiverPostId}")
    public ResponseEntity<ApiResponse> requestMatching(@PathVariable Long receiverPostId, @RequestBody MatchingRequest request) {

        MatchingMember matchingMember = matchingService.createMatchingRequest(request.getMemberId(), receiverPostId, request.getChatLink());

        MatchingMemberDto matchingMemberDto = MatchingMemberDto.of(matchingMember);
        ApiResponse response = new RequestMatchingResponse(matchingMemberDto);

        return ResponseEntity.ok(response);
    }


    //    내가 받은 메일 가져오기
    @GetMapping("/notification/receieve/{memberId}")
    public ResponseEntity<ApiResponse> getReceiveMail(@PathVariable Long memberId) {
        List<MatchingMemberDto> matchingList = matchingService.getAllReceiveMail(memberId);

        ApiResponse response = new ReceiveMailListResponse(matchingList);

        return ResponseEntity.ok(response);
    }

    //    내가 보낸 메일 가져오기
    @GetMapping("/notification/sent/{memberId}")
    public ResponseEntity<ApiResponse> getSentMail(@PathVariable Long memberId) {
        List<MatchingMemberDto> matchingList = matchingService.getAllsentMail(memberId);

        ApiResponse response = new ReceiveMailListResponse(matchingList);

        return ResponseEntity.ok(response);
    }
//    수락/거절



}
