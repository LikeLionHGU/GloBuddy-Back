package com.likelion.GloBuddyBackend.controller.response.Post;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import com.likelion.GloBuddyBackend.controller.response.ApiResponse;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class PostIdResponse extends ApiResponse {

    private Long postId;
}
