package com.likelion.GloBuddyBackend.controller;

import com.likelion.GloBuddyBackend.controller.request.MemberRequest;
import com.likelion.GloBuddyBackend.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/mypage")
@RequiredArgsConstructor
public class MypageController {

    @PatchMapping("/{memberId}")
    public ResponseEntity<Void> editMember(
            @PathVariable Long memberId, @RequestBody MemberRequest request) {

        MemberDto dto = MemberDto.of(request);
        memberService.editMember(dto, memberId);

        return ResponseEntity.ok().build();
    }
}
