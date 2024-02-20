package com.likelion.GloBuddyBackend.dto;

import com.likelion.GloBuddyBackend.domain.Needs;
import com.likelion.GloBuddyBackend.domain.Post;
import com.likelion.GloBuddyBackend.controller.request.PostRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {
    private Long postId;
    private Long memberId;
    private String title;
    private String content;
    private String name;
    private boolean deleted;
    private LocalDateTime createdDate;
    private String color;
    private String needs;
    private String needs2;
    private String needs3;

    public static PostDto from(Post post) {  // DataToObject
        return PostDto.builder()
                .postId(post.getPostId())
                .memberId(post.getMember().getMemberId())
                .title(post.getTitle())
                .content(post.getContent())
                .createdDate(post.getCreatedDate())
                .name(post.getMember().getName())
                .deleted(post.isDeleted())
                .build();
    }

    public static PostDto from(Post post, Needs needs) {  // DataToObject
        return PostDto.builder()
                .postId(post.getPostId())
                .memberId(post.getMember().getMemberId())
                .title(post.getTitle())
                .content(post.getContent())
                .createdDate(post.getCreatedDate())
                .name(post.getMember().getName())
                .deleted(post.isDeleted())

                .color(needs.getColor())
                .needs(needs.getNeeds())
                .build();
    }

    public static PostDto from(PostRequest postRequest) {
        return PostDto.builder()
                .memberId(postRequest.getMemberId())
                .title(postRequest.getTitle())
                .content(postRequest.getContent())
                .needs(postRequest.getNeeds())
                .color(postRequest.getColor())
                .build();

    }


}
