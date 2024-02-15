package com.likelion.GloBuddyBackend.controller.response.MemberDetail;

import com.likelion.GloBuddyBackend.controller.response.ApiResponse;
import com.likelion.GloBuddyBackend.dto.MemberDetailDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberDetailResponse extends ApiResponse {

  private Long memberDetailId;
  private Long memberId;

  private String gender;
  private String nation;

  private int numNotification;
  private String type;
  private String needs;

  public MemberDetailResponse(MemberDetailDto dto) {
    this.memberDetailId = dto.getMemberDetailId();
    this.memberId = dto.getMemberId();
    this.gender = dto.getGender();
    this.nation = dto.getNation();
    this.numNotification = dto.getNumNotification();
    this.needs = dto.getNeeds();
    this.type = dto.getMbti();
  }
}
