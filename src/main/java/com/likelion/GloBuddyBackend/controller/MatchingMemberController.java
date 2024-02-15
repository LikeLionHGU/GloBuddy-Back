package com.likelion.GloBuddyBackend.controller;

import com.likelion.GloBuddyBackend.controller.request.MemberDetailRequest;
import com.likelion.GloBuddyBackend.controller.response.ApiResponse;
import com.likelion.GloBuddyBackend.dto.MemberDetailDto;
import com.likelion.GloBuddyBackend.service.MatchingMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/matching")
@RequiredArgsConstructor
public class MatchingMemberController {

    private final MatchingMemberService memberService;


    @PostMapping("/{receiverId}")
    public ResponseEntity<ApiResponse> requestMatching(@RequestBody Long receiverId) {



        return ResponseEntity.created(uri).build();
    }

}
