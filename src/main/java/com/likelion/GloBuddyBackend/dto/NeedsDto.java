package com.likelion.GloBuddyBackend.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class NeedsDto {

    private Long needsId;

    private String needs;

    public static NeedsDto of (Needs needs){
        return NeedsDto.builder()
                .needsId(needs.getNeedsId())
                .needs(needs.getNeeds())
                .build();
    }


}
