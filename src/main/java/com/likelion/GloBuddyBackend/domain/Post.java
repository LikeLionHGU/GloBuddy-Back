package com.likelion.GloBuddyBackend.domain;

import com.likelion.GloBuddyBackend.dto.PostDto;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Post extends BaseTime{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    public static Post toPost(PostDto postDto, Member member){
        return Post.builder()
                .title(postDto.getTitle())
                .content(postDto.getContent())
                .member(member)
                .build();
    }

    public void update(PostDto postDto) {
        this.title = postDto.getTitle();
        this.content = postDto.getContent();


    }

}
