package com.likelion.GloBuddyBackend.controller.response.Matching;

import com.likelion.GloBuddyBackend.controller.response.ApiResponse;
import com.likelion.GloBuddyBackend.dto.MatchingMemberDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
@AllArgsConstructor
public class MailResponse extends ApiResponse {

    private Long matchingId ;

    private Long senderId;
    private Long receiverId;

    private byte IfMatched;

    private boolean IfChecked;

    private String chatLink;

    private String message;

    private Long num;

    public MailResponse(MatchingMemberDto dto){
        this.matchingId= dto.getMatchingId();
        this.senderId = dto.getSenderId();
        this.receiverId =dto.getReceiverId();
        this.IfChecked = dto.isIfChecked();
        this.IfMatched = dto.getIfMatched();
        this.chatLink = dto.getChatLink();
        this.message = dto.getMessage();
        this.num = dto.getNum();
    }

}
