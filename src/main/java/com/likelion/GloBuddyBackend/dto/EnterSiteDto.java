package com.likelion.GloBuddyBackend.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EnterSiteDto {

    private boolean registered;
    private Long memberId;
}
