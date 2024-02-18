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
public class MatchingMember extends BaseTime{

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

// book - checkout - member //  member - post -me
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "receiver_Id" )
    private Post post;

    public static MatchingMember of(Member sender, Post receiverPost,String chatLink, String message){
        return MatchingMember.builder()
                .member(sender)
                .post(receiverPost)
                .chatLink(chatLink)
                .message(message)
                .build();
    }

    public static MatchingMember of(MatchingMemberDto dto,Member member){
        return MatchingMember.builder()
                .matchingId(dto.getMatchingId())
                .IfMatched(dto.getIfMatched())
                .IfChecked(dto.isIfChecked())
                .chatLink(dto.getChatLink())
                .message(dto.getMessage())
                .member(member)
                .build();

    }

    public void update(MatchingMemberDto dto){

        this.matchingId=dto.getMatchingId();
        this.IfChecked = dto.isIfChecked();
        this.chatLink = dto.getChatLink();
        this.IfMatched = dto.getIfMatched();
        this.message = dto.getMessage();

    }




}
