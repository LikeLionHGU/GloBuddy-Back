package com.likelion.GloBuddyBackend.controller;

import com.likelion.GloBuddyBackend.controller.request.MatchingChoiceRequest;
import com.likelion.GloBuddyBackend.controller.request.MatchingRequest;
import com.likelion.GloBuddyBackend.controller.response.ApiResponse;
import com.likelion.GloBuddyBackend.controller.response.Matching.*;
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

        MatchingMemberDto matchingMemberDto = MatchingMemberDto.of(request);

        MatchingMemberDto resultDto = matchingService.createMatchingRequest(matchingMemberDto , receiverPostId);

        ApiResponse response = new RequestMatchingResponse(resultDto);

        return ResponseEntity.ok(response);
    }




    @PatchMapping("/notification/receive/{memberId}/choice/{matchingId}")
    public ResponseEntity<ApiResponse> choiceMatching(@PathVariable Long memberId, @PathVariable Long matchingId ,  @RequestBody MatchingChoiceRequest request) {
        MatchingMemberDto matchingMemberDto = MatchingMemberDto.of(request);
        matchingService.choiceMatching(matchingMemberDto, matchingId);

        ApiResponse response = new MailResponse(matchingMemberDto);

        return ResponseEntity.ok(response);
    }

    @PatchMapping("/notification/sent/{memberId}/check/{matchingId}")
    public String checkMatching(@PathVariable Long memberId, @PathVariable Long matchingId ) {

        matchingService.checkMatching(matchingId);


        return "Checked";
    }



    @GetMapping("/notification/receive/{memberId}")
    public ResponseEntity<ApiResponse> getReceiveMail(@PathVariable Long memberId) {
        List<MatchingMemberDto> matchingList = matchingService.getAllReceiveMail(memberId);


        ApiResponse response = new RequestMatchingListResponse(matchingList);

        return ResponseEntity.ok(response);
    }


    @GetMapping("/notification/sent/{memberId}")
    public ResponseEntity<ApiResponse> getSentMail(@PathVariable Long memberId) {
        List<MatchingMemberDto> matchingList = matchingService.getAllsentMail(memberId);

        ApiResponse response = new MailListResponse(matchingList);

        return ResponseEntity.ok(response);
    }



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