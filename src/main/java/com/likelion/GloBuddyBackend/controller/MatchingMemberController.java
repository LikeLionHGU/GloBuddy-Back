package com.likelion.GloBuddyBackend.controller;

import com.likelion.GloBuddyBackend.controller.request.MatchingRequest;
import com.likelion.GloBuddyBackend.controller.request.MemberDetailRequest;
import com.likelion.GloBuddyBackend.controller.response.ApiResponse;
import com.likelion.GloBuddyBackend.controller.response.Matching.RequestMatchingResponse;
import com.likelion.GloBuddyBackend.controller.response.Post.PostIdResponse;
import com.likelion.GloBuddyBackend.dto.MatchingMemberDto;
import com.likelion.GloBuddyBackend.dto.MemberDetailDto;
import com.likelion.GloBuddyBackend.dto.PostDto;
import com.likelion.GloBuddyBackend.service.MatchingMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/matching")
@RequiredArgsConstructor
public class MatchingMemberController {

    private final MatchingMemberService memberService;


    @PostMapping("/{receiverPostId}")
    public ResponseEntity<ApiResponse> requestMatching(@PathVariable Long receiverPostId, @RequestBody MatchingRequest request) {

        Long matchingId= memberService.createMatchingRequest(request.getMemberId(),receiverPostId);

        ApiResponse response = new RequestMatchingResponse(matchingId);

        return ResponseEntity.ok(response);
    }

}
