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

    private boolean deleted;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member ;

//    @OneToMany
//    private Needs needs;
    public static Post toPost(PostDto postDto, Member member){ // 레포지토리 들어가는 용
        return Post.builder()
                .title(postDto.getTitle())
                .content(postDto.getContent())
                .member(member)
                .deleted(false)
                .build();
    }


    public static PostDto of(Post post , Needs needs) {
        return PostDto.builder()
                .title(post.getTitle())
                .content(post.getContent())
                .deleted(post.isDeleted())
                .needs(needs.getNeeds())
                .color(needs.getColor())
                .build();

    }

    public void delete(Post post) {
        post.deleted = true;
    }
    public void update(PostDto postDto) {
        this.title = postDto.getTitle();
        this.content = postDto.getContent();

    }

}
