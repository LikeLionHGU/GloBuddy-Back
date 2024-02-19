package com.likelion.GloBuddyBackend.domain;

import com.likelion.GloBuddyBackend.dto.MatchingMemberDto;
import com.likelion.GloBuddyBackend.dto.MemberDto;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MatchingMember extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long matchingId;

    @ColumnDefault("0")
    private byte IfMatched;

    @ColumnDefault("false")
    private boolean IfChecked;

    @Column(nullable = false)
    private String chatLink;

    private String message;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sender_id")
    private Member member;

    private Long receiverId;

    // book - checkout - member //  member - post -me
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_Id")
    private Post post;

    public static MatchingMember of(Member sender, Post receiverPost, String chatLink, String message) {
        return MatchingMember.builder()
                .member(sender)
                .post(receiverPost)
                .chatLink(chatLink)
                .message(message)
                .build();
    }

    public static MatchingMember of(Member member, Post post, MatchingMemberDto dto) {
        return MatchingMember.builder()
                .matchingId(dto.getMatchingId())
                .member(member)
                .post(post)
                .IfMatched(dto.getIfMatched())
                .IfChecked(dto.isIfChecked())
                .chatLink(dto.getChatLink())
                .message(dto.getMessage())
                .receiverId(post.getMember().getMemberId())
                .build();

    }

    public void update(MatchingMemberDto dto) {

        this.matchingId = dto.getMatchingId();
        this.IfChecked = dto.isIfChecked();
        this.chatLink = dto.getChatLink();
        this.IfMatched = dto.getIfMatched();
        this.message = dto.getMessage();

    }


}
