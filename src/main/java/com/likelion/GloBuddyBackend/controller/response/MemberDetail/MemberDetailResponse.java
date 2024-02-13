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

    private String gender;
    private String nation;

    private int numNotification;
    private Type type;
    private Needs needs;

    public MemberDetailResponse(MemberDetailDto dto){
      this.memberDetailId=dto.getMemberDetailId();
      this.gender=dto.getGender();
      this.nation=dto.getNation();
      this.numNotification=dto.getNumNotification();

    }



}
