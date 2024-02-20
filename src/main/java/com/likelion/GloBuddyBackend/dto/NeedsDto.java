package com.likelion.GloBuddyBackend.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class NeedsDto {

    private Long needsId;
    private String needs;
    private String color;
    private Long postId;

    public static NeedsDto from(PostDto dto) {

        return NeedsDto.builder()
                .needs(dto.getNeeds())
                .color(dto.getColor())
                .build();

    }

}
