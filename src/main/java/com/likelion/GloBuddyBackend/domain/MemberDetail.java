package com.likelion.GloBuddyBackend.domain;

import com.likelion.GloBuddyBackend.dto.MemberDetailDto;
import com.likelion.GloBuddyBackend.dto.MyInfoEditDto;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberDetail extends BaseTime {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long memberDetailId;

  private String gender;
  private String nation;
  private String mbti;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "member_id")
  private Member member;

  public static MemberDetail create(MemberDetailDto dto) {
    return MemberDetail.builder()
        .gender(dto.getGender())
        .nation(dto.getNation())
        .mbti(dto.getMbti())
        .build();
  }

  public static MemberDetail create(MemberDetailDto dto, Member member) {
    return MemberDetail.builder()
        .gender(dto.getGender())
        .nation(dto.getNation())
        .mbti(dto.getMbti())
        .member(member)
        .build();
  }

  public void update(MemberDetailDto dto) {
    this.gender = dto.getGender();
    this.nation = dto.getNation();
    this.mbti =dto.getMbti();
  }

  public static MemberDetail toMemberDetail(MemberDetailDto memberDetailDto, Member member) {
    return MemberDetail.builder()
            .member(member)
        .gender(memberDetailDto.getGender())
        .nation(memberDetailDto.getNation())
        .build();
  }

    public void infoUpdate(MyInfoEditDto dto) {
      this.gender = dto.getGender();
      this.nation = dto.getNation();
      this.mbti =dto.getMbti();
    }
}
