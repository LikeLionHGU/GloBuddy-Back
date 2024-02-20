package com.likelion.GloBuddyBackend.controller.response.Post;

import com.likelion.GloBuddyBackend.controller.response.ApiResponse;
import com.likelion.GloBuddyBackend.dto.PostDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
public class PostResponse extends ApiResponse {

    private Long postId;
    private String title;
    private String content;
    private String name;
    private boolean deleted;
    private LocalDateTime createdDate;
    private String needs;
    private String needs2;
    private String needs3;
    private String color;

    public PostResponse(PostDto post) {
        this.postId = post.getPostId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.name = post.getName();
        this.deleted = post.isDeleted();
        this.needs = post.getNeeds();
        this.needs2 = post.getNeeds2();
        this.needs3 = post.getNeeds3();
        this.color = post.getColor();
        this.createdDate = post.getCreatedDate();

    }

}
