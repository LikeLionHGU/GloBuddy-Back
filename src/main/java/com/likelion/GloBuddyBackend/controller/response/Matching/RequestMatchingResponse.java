package com.likelion.GloBuddyBackend.controller.response.Matching;

import com.likelion.GloBuddyBackend.controller.response.ApiResponse;
import com.likelion.GloBuddyBackend.dto.MatchingMemberDto;
import com.likelion.GloBuddyBackend.dto.MemberDto;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

@Getter
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
@AllArgsConstructor
public class RequestMatchingResponse extends ApiResponse {

    private Long matchingId ;

    private Long senderId;
    private Long receiverId;

    private byte IfMatched;

    private boolean IfChecked;

    private String chatLink;
    private String message;


    public RequestMatchingResponse(MatchingMemberDto dto){
        this.matchingId= dto.getMatchingId();
        this.senderId = dto.getSenderId();
        this.receiverId =dto.getReceiverId();
        this.IfChecked = dto.isIfChecked();
        this.IfMatched = dto.getIfMatched();
        this.chatLink = dto.getChatLink();
        this.message = dto.getMessage();
    }
}
