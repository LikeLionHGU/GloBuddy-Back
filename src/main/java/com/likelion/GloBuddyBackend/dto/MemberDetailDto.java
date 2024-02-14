package com.likelion.GloBuddyBackend.dto;

import com.likelion.GloBuddyBackend.controller.request.MemberDetailRequest;
import com.likelion.GloBuddyBackend.controller.request.MemberRequest;
import com.likelion.GloBuddyBackend.domain.Member;
import com.likelion.GloBuddyBackend.domain.MemberDetail;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MemberDetailDto {

  private Long memberId;
  private Long memberDetailId;

  private String gender;
  private String nation;
  private int numNotification;
  private String needs;
  private String type;

  public static MemberDetailDto of(MemberDetail memberDetail) {
    return MemberDetailDto.builder()
        .memberDetailId(memberDetail.getMemberDetailId())
        .memberId(memberDetail.getMember().getMemberId())
        .gender(memberDetail.getGender())
        .nation(memberDetail.getNation())
        .numNotification(memberDetail.getNumNotification())
        .needs(memberDetail.getNeeds())
        .type(memberDetail.getType())
        .build();
  }

  public static MemberDetailDto of(MemberDetailRequest memberDetailRequest) {
    return MemberDetailDto.builder()
        .memberDetailId(memberDetailRequest.getMemberId())
        .memberId(memberDetailRequest.getMemberId())
        .gender(memberDetailRequest.getGender())
        .nation(memberDetailRequest.getNation())
        .needs(memberDetailRequest.getNeeds())
        .type(memberDetailRequest.getType())
        .build();
  }
}
