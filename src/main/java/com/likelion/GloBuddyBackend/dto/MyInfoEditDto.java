package com.likelion.GloBuddyBackend.dto;

import com.likelion.GloBuddyBackend.controller.request.MyInfoEditRequest;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MyInfoEditDto {
    private String name;
    private String nation;
    private String gender;
    private String mbti;

    public static MyInfoEditDto of(MyInfoEditRequest request){
        return MyInfoEditDto.builder()
                .name(request.getName())
                .nation(request.getNation())
                .gender(request.getGender())
                .mbti(request.getMbti())
                .build();
    }
}
