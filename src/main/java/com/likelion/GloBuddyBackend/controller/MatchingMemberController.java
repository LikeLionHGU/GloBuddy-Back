package com.likelion.GloBuddyBackend.controller;

import com.likelion.GloBuddyBackend.controller.request.MatchingRequest;
import com.likelion.GloBuddyBackend.controller.response.ApiResponse;
import com.likelion.GloBuddyBackend.controller.response.Matching.MailNumResponse;
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

        MatchingMember matchingMember = matchingService.createMatchingRequest(request.getMemberId(), receiverPostId, request.getChatLink(),request.getMessage());


        MatchingMemberDto matchingMemberDto = MatchingMemberDto.of(matchingMember);
        ApiResponse response = new RequestMatchingResponse(matchingMemberDto);

        return ResponseEntity.ok(response);
    }


    @GetMapping("/notification/receive/{memberId}")
    public ResponseEntity<ApiResponse> getReceiveMail(@PathVariable Long memberId) {
        List<MatchingMemberDto> matchingList = matchingService.getAllReceiveMail(memberId);

        ApiResponse response = new ReceiveMailListResponse(matchingList);

        return ResponseEntity.ok(response);
    }


    @GetMapping("/notification/sent/{memberId}")
    public ResponseEntity<ApiResponse> getSentMail(@PathVariable Long memberId) {
        List<MatchingMemberDto> matchingList = matchingService.getAllsentMail(memberId);

        ApiResponse response = new ReceiveMailListResponse(matchingList);

        return ResponseEntity.ok(response);
    }
//    수락/거절



    //     알림 개수
    @GetMapping("/notification/sent/num/{memberId}")
    public ResponseEntity<ApiResponse> getNumOfSentMail(@PathVariable Long memberId) {

        Long numOfSentMail = matchingService.getNumOfSentMail(memberId);
        ApiResponse response = new MailNumResponse(numOfSentMail);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/notification/received/num/{memberId}")
    public ResponseEntity<ApiResponse> getNumOfReceivedMail(@PathVariable Long memberId) {

        Long numOfReceivedMail = matchingService.getNumOfReceiveMail(memberId);
        ApiResponse response = new MailNumResponse(numOfReceivedMail);

        return ResponseEntity.ok(response);
    }



}