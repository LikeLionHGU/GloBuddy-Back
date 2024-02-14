package com.likelion.GloBuddyBackend.domain;

import com.likelion.GloBuddyBackend.dto.MemberDetailDto;
import com.likelion.GloBuddyBackend.dto.MemberDto;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberDetail {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long memberDetailId;

  private String gender;
  private String nation;

  @ColumnDefault("0")
  private int numNotification;

  private String needs;
  private String type;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "member_id")
  private Member member;

  public static MemberDetail create(MemberDetailDto dto) {
    return MemberDetail.builder()
        .gender(dto.getGender())
        .nation(dto.getNation())
        .numNotification(dto.getNumNotification())
        .needs(dto.getNeeds())
        .type(dto.getType())
        .build();
  }

  public static MemberDetail create(MemberDetailDto dto, Member member) {
    return MemberDetail.builder()
        .gender(dto.getGender())
        .nation(dto.getNation())
        .numNotification(dto.getNumNotification())
        .needs(dto.getNeeds())
        .type(dto.getType())
        .member(member)
        .build();
  }

  public void update(MemberDetailDto dto) {
    this.gender = dto.getGender();
    this.nation = dto.getNation();
    this.numNotification = dto.getNumNotification();
    this.needs=dto.getNeeds();
    this.type=dto.getType();
  }

  public static MemberDetail toMemberDetail(MemberDetailDto memberDetailDto, Member member) {
    return MemberDetail.builder()
            .member(member)
        .gender(memberDetailDto.getGender())
        .nation(memberDetailDto.getNation())
        .numNotification(memberDetailDto.getNumNotification())
        .member(member)
        .build();
  }
}
