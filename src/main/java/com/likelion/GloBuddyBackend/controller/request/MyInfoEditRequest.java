package com.likelion.GloBuddyBackend.controller.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MyInfoEditRequest {

    private String name;
    private String nation;
    private String gender;
    private String mbti;

}
