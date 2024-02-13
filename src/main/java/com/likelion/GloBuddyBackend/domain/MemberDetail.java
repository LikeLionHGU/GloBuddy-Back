package com.likelion.GloBuddyBackend.domain;

import com.likelion.GloBuddyBackend.dto.MemberDetailDto;
import com.likelion.GloBuddyBackend.dto.MemberDto;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import lombok.*;

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
  private int numNotification;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "member_id")
  private Member member;

  public static MemberDetail create(MemberDetailDto dto) {
    return MemberDetail.builder()
        .gender(dto.getGender())
        .nation(dto.getNation())
        .numNotification(dto.getNumNotification())
        .build();
  }

  public void update(MemberDetailDto dto) {
    this.gender = dto.getGender();
    this.nation = dto.getNation();
    this.numNotification = dto.getNumNotification();
  }

}
