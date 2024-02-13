package com.likelion.GloBuddyBackend.controller.request;

import com.likelion.GloBuddyBackend.domain.Member;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberDetailRequest {

    private String gender;
    private String nation;

    private String type;
    private String needs;



}
