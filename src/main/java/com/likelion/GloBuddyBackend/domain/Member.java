package com.likelion.GloBuddyBackend.domain;

import com.likelion.GloBuddyBackend.dto.MemberDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    private String name;

    private String email;

    private String image;


    public static Member create(MemberDto dto){
        return Member.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .image(dto.getImage())
                .build();
    }

    public void update(MemberDto dto){
        this.name=dto.getName();
        this.email=dto.getEmail();
        this.image=dto.getImage();
    }



}
