package com.likelion.GloBuddyBackend.controller;

import com.likelion.GloBuddyBackend.controller.request.MemberDetailRequest;
import com.likelion.GloBuddyBackend.controller.request.MemberRequest;
import com.likelion.GloBuddyBackend.controller.response.ApiResponse;
import com.likelion.GloBuddyBackend.controller.response.Member.MemberResponse;
import com.likelion.GloBuddyBackend.controller.response.MemberDetail.MemberDetailResponse;
import com.likelion.GloBuddyBackend.domain.MemberDetail;
import com.likelion.GloBuddyBackend.dto.MemberDetailDto;
import com.likelion.GloBuddyBackend.dto.MemberDto;
import com.likelion.GloBuddyBackend.service.MemberDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/memberDetail")
@RequiredArgsConstructor
@CrossOrigin("*")
public class MemberDetailController {

  private final MemberDetailService memberDetailService;

  @PostMapping
  public ResponseEntity<ApiResponse> addMember(@RequestBody MemberDetailRequest request) {
    MemberDetailDto dto = MemberDetailDto.of(request);
    Long memberDetailId = memberDetailService.addMemberDetail(dto);

    URI uri = URI.create("/memberDetail/" + memberDetailId);

    return ResponseEntity.created(uri).build();
  }

  @GetMapping("/{memberId}")
  public ResponseEntity<MemberDetailResponse> getMemberDetail(@PathVariable Long memberId) {

    MemberDetailResponse response = new MemberDetailResponse(memberDetailService.getMemberDetails(memberId));

    return ResponseEntity.ok(response);
  }

  @PatchMapping("/{memberId}")
  public ResponseEntity<Void> editMemberDetail(
          @PathVariable Long memberId, @RequestBody MemberDetailRequest request) {

    MemberDetailDto dto = MemberDetailDto.of(request);
    memberDetailService.editMemberDetail(dto, memberId);

    return ResponseEntity.ok().build();
  }

}