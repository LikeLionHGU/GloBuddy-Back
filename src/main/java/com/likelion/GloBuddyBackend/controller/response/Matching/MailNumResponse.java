package com.likelion.GloBuddyBackend.controller.response.Matching;

import com.likelion.GloBuddyBackend.controller.response.ApiResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
@AllArgsConstructor
public class MailNumResponse extends ApiResponse {

    private Long num;
}
