package com.likelion.GloBuddyBackend.controller;

import com.likelion.GloBuddyBackend.controller.request.MemberRequest;
import com.likelion.GloBuddyBackend.controller.response.ApiResponse;
import com.likelion.GloBuddyBackend.controller.response.Member.MemberListResponse;
import com.likelion.GloBuddyBackend.controller.response.Member.MemberResponse;
import com.likelion.GloBuddyBackend.dto.MemberDto;
import com.likelion.GloBuddyBackend.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public ResponseEntity<ApiResponse> addMember(@RequestBody MemberRequest request) {
        MemberDto dto = MemberDto.of(request);
        Long memberId = memberService.addMember(dto);
        URI uri = URI.create("/members/" + memberId);

        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<MemberListResponse> getAllMembers() {
        List<MemberDto> members = memberService.getAllMembers();
        MemberListResponse response = new MemberListResponse(members);

        return ResponseEntity.ok(response);
    }


    @PutMapping("/{memberId}")
    public ResponseEntity<Void> editMember(@PathVariable Long memberId, @RequestBody MemberRequest request){

    MemberDto dto = MemberDto.of(request);
    memberService.editMember(dto,memberId);

    return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{memberId}")
    public ResponseEntity<Void> deleteMember(@PathVariable Long memberId) {
        memberService.delete(memberId);

        return ResponseEntity.ok().build();
    }


}

