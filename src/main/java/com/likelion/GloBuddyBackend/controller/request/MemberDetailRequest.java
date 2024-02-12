package com.likelion.GloBuddyBackend.controller.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberDetailRequest {

    private String gender;
    private String nation;
    private int numNotification;
    private String type;
    private String needs;

}
