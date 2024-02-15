package com.likelion.GloBuddyBackend.domain;

import com.likelion.GloBuddyBackend.dto.MemberDto;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Getter
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



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sender_id")
    private Member member;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "receiver_Id" , referencedColumnName = "member_id")
    private Post post;

    public static MatchingMember of(Member sender, Post receiverPost){
        return MatchingMember.builder()
                .member(sender)
                .post(receiverPost)
                .build();
    }

}
