package com.likelion.GloBuddyBackend.domain;

import com.likelion.GloBuddyBackend.dto.NeedsDto;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Needs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long NeedsId;

    @Column(nullable = false)
    private String needs;
    private String color;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    public static Needs toNeeds(NeedsDto needsDto, Post post) {
        return Needs.builder()
                .post(post)
                .needs(needsDto.getNeeds())
                .color(needsDto.getColor())
                .build();
    }



}
