package com.likelion.GloBuddyBackend.controller.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberDetailRequest {

    private String gender;
    private String nation;
    private int numNotification;
    private List<String> type;
    private List<String> needs;

}
