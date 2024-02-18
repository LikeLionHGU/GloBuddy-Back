package com.likelion.GloBuddyBackend.controller.response.Post;

import com.likelion.GloBuddyBackend.controller.response.ApiResponse;
import com.likelion.GloBuddyBackend.dto.PostDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;


import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
public class PostResponse extends ApiResponse {

    private Long postId;
    private String title;
    private String content;
    private String name;
    private LocalDateTime createdDate;

    public PostResponse(PostDto post) {
        this.postId = post.getPostId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.name = post.getName();
        this.createdDate = post.getCreatedDate();
    }

}
