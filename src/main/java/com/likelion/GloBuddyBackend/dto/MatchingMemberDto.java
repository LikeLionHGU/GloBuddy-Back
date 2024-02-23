package com.likelion.GloBuddyBackend.dto;

import com.likelion.GloBuddyBackend.controller.request.MatchingChoiceRequest;
import com.likelion.GloBuddyBackend.controller.request.MatchingRequest;
import com.likelion.GloBuddyBackend.domain.MatchingMember;
import com.likelion.GloBuddyBackend.domain.Member;
import com.likelion.GloBuddyBackend.domain.MemberDetail;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MatchingMemberDto {

    private Long matchingId;
    private Long senderId;

    private String senderName;
    private String senderMbti;
    private String senderGender;
    private String senderNation;

    private Long postId;
    private Long receiverId;
    private String receiverName;

    private byte ifMatched;

    private boolean ifChecked;
    private String chatLink;
    private String message;



    public static MatchingMemberDto of(Member sender, Member receiver) {

        return MatchingMemberDto.builder()
                .senderId(sender.getMemberId())
                .receiverId(receiver.getMemberId())
                .build();
    }



    public static MatchingMemberDto of(MatchingRequest matchingRequest) {

        return MatchingMemberDto.builder()
                .senderId(matchingRequest.getMemberId())
                .chatLink(matchingRequest.getChatLink())
                .message(matchingRequest.getMessage())
                .build();
    }

    public static MatchingMemberDto of(MatchingChoiceRequest matchingChoiceRequest) {

        return MatchingMemberDto.builder()

                .ifMatched(matchingChoiceRequest.getIfMatched())
                .build();
    }



    public static MatchingMemberDto of(MatchingMember matchingMember) {

        return MatchingMemberDto.builder()
                .matchingId(matchingMember.getMatchingId())
                .senderId(matchingMember.getMember().getMemberId())
                .receiverId(matchingMember.getPost().getMember().getMemberId())
                .receiverName((matchingMember.getPost().getMember().getName()))
                .ifMatched(matchingMember.getIfMatched())
                .ifChecked(matchingMember.isIfChecked())
                .chatLink(matchingMember.getChatLink())
                .senderName(matchingMember.getMember().getName())
                .message(matchingMember.getMessage())
                .build();
    }

    public static MatchingMemberDto of(MatchingMember matchingMember, MemberDetail detail) {

        return MatchingMemberDto.builder()
                .matchingId(matchingMember.getMatchingId())
                .senderId(matchingMember.getMember().getMemberId())
                .receiverId(matchingMember.getPost().getMember().getMemberId())
                .receiverName((matchingMember.getPost().getMember().getName()))

                .ifMatched(matchingMember.getIfMatched())
                .ifChecked(matchingMember.isIfChecked())
                .chatLink(matchingMember.getChatLink())
                .senderName(matchingMember.getMember().getName())
                .senderMbti(detail.getMbti())
                .senderGender(detail.getGender())
                .senderNation(detail.getNation())
                .message(matchingMember.getMessage())
                .build();
    }


}
