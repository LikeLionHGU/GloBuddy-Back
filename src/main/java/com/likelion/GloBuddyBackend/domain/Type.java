package com.likelion.GloBuddyBackend.domain;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long typeId;

    private String type;

    @ManyToOne
    @JoinColumn(name = "member_detaile_id")
    private MemberDetail memberDetail;




}
