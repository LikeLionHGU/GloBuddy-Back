package com.likelion.GloBuddyBackend.dto;

import com.likelion.GloBuddyBackend.domain.Type;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TypeDto {

    private Long typeId;

    private String type;

    public static TypeDto of(Type type){
        return TypeDto.builder()
                .typeId(type.getTypeId())
                .type(type.getType())
                .build();
    }
}
