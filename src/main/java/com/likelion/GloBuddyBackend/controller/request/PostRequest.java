package com.likelion.GloBuddyBackend.controller.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
@Getter
@NoArgsConstructor
public class PostRequest {
    private Long memberId;
    private String title;
    private String content;
}
