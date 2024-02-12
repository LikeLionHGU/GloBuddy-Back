package com.likelion.GloBuddyBackend.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Needs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long needsId;

    private String needs;

    @ManyToOne
    @JoinColumn(name="member_detail_id")
    private MemberDetail memberDetail;
}
