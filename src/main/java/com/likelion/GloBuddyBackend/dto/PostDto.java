package com.likelion.GloBuddyBackend.dto;

import com.likelion.GloBuddyBackend.domain.MemberDetail;
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
    private String mbti;
    private String gender;
    private String nation;

    // post 세부내용 가져올 때쓰는 from
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

    public static PostDto from(Post post, Needs needs, MemberDetail detail) {  // DataToObject
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

                .mbti(detail.getMbti())
                .gender(detail.getGender())
                .nation(detail.getNation())
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
