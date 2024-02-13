package com.likelion.GloBuddyBackend.controller.response.Member;

import com.likelion.GloBuddyBackend.controller.response.ApiResponse;
import com.likelion.GloBuddyBackend.dto.MemberDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberResponse extends ApiResponse {

  private Long memberId;

  private String name;

  private String email;

  private String image;

  public MemberResponse(MemberDto dto){
      this.memberId = dto.getMemberId();
      this.name = dto.getName();
      this.email = dto.getEmail();
      this.image = dto.getPicture();
  }
}
